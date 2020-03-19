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


# Hotspot GC tuning 
+ Heap management 
+ Hotspot Parallel GC & CMS GC 
+ GC logs : VisualVM & VisualGC, metaspace, young allocation, reclamation and promotion
+ GC performance tuning 
  + reduce latency 
  + tune throughput 
  + tune for latency 
  + concurrent making phase 
  + G1 GC : tune young collections 
  + fragmentation, evacuation failure, full GC 
  + utilize region size tuning to help avoid failures due to humongous objects 
  + utilize tuning to adjust marking threshold or concurrent threads or reclaim more regions.
