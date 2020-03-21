package com.filesearch;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

public class ParallelGroupFileTask implements Runnable {

    private final String fileName;
    private final ConcurrentLinkedQueue<File> directories;
    private final Future parallelResult;
    private boolean found;

    public ParallelGroupFileTask(String fileName, Future parallelResult,
                                 ConcurrentLinkedQueue<File>directories) {
        this.fileName = fileName;
        this.parallelResult = parallelResult;
        this.directories = directories;
        this.found = false;
    }

    @Override
    public void run() {
        while (directories.size() > 0) {
            File file = directories.poll();
            try {
                processDirectory(file, fileName, parallelResult);
                if (found) {
                    System.out.printf("%s has found the file%n",
                            Thread.currentThread().getName());
                    System.out.printf("Parallel Search: Path: %s%n",
                            parallelResult.getPath());
                    return;
                }
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted%n",
                        Thread.currentThread().getName());
            }
        }
    }

    /**
     * Process Dir
     * @param file
     * @param fileName
     * @param parallelResult
     * @throws InterruptedException
     */
    private void processDirectory(File file, String fileName,
                                  Future parallelResult) throws InterruptedException {
        File[] contents;
        contents = file.listFiles();

        if ((contents == null) || (contents.length == 0)) {
            return;
        }

        for (File content : contents) {
            if (content.isDirectory()) {
                processDirectory(content, fileName, parallelResult);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                if (found) {
                    return;
                }
            } else {
                processFile(content, fileName, parallelResult);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                if (found) {
                    return;
                }
            }
        }
    }

    /**
     * Process file
     * @param content
     * @param fileName
     * @param parallelResult
     */
    private void processFile(File content, String fileName,
                             Future parallelResult) {
        if (content.getName().equals(fileName)) {
            parallelResult.setPath(content.getAbsolutePath());
            this.found = true;
        }
    }

    public boolean getFound() {
        return found;
    }
}
