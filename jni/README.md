# JNI

- compile Java class    
    - javac JavaProgram.java


- create native method header file 
    - javah -jni Program

- compile C source and create a native lib 
    - System.loadLibrary("HelloWorld");

- build dynamic link library DLL using C++ compiler 

- run 
    