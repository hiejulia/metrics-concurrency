# metrics-concurrency
Benchmark/ metrics for concurrency Java applications 
(benchmark JVM, CPU, OS,etc)

## Metrics 
+ test
+ code coverage 
+ JVM execution threads, CPU, etc




## Stack/ Tools 
+ JConsole 
+ Jtest
+ Findbug 
+ PMD
+ VisualVM
    + `jvisualvm` 



# Hotspot GC tuning 
+ Heap management 
    + Allocation - lock free out of Thread local area buffers 
    + GC root set : loaded class, static fields, live threads, JNI local and global
    + Young generation : Eden TLAB _ 
+ GC 
    + algorithms 
    + YG collectors : reclamation
        + collections employs parallel GC worker threads that have their own work queues and also can perform work stealing are employed to reduce the pause time per collection
        + surviving obj = copied - aged in survivor spaces 
        + overflow + ageed obj = OG 
        + Promote thread local buffer 
    + OG : parallel mark sweep ad compaction
+ Hotspot Parallel GC & CMS GC 
+ GC logs : VisualVM & VisualGC, metaspace, young allocation, reclamation and promotion
    + log options : (-XX:+UseSerialGC -Xms1024m -Xmx1024m -verbose:gc -XX:+PrintGCDetails) | -XX:+PrintGCDetails
+ GC performance tuning 
  + reduce latency 
  + tune throughput 
  + tune for latency 
  + concurrent making phase 
  + G1 GC : tune young collections 
  + fragmentation, evacuation failure, full GC 
  + utilize region size tuning to help avoid failures due to humongous objects 
  + utilize tuning to adjust marking threshold or concurrent threads or reclaim more regions.
