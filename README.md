# metrics-concurrency
- Network programming with Java & C, ++ 
- Benchmark/ metrics for concurrency Java applications 
(benchmark JVM, CPU, OS,etc)
- IoT network programming with C 


<a href="https://imgur.com/sZFgJGx"><img src="https://i.imgur.com/sZFgJGx.png" title="source: imgur.com" /></a>

# Network 
`TRACERT`
`brew install libssh`
- IPv4 and IPv6
- Internet Assigned Numbers Authority (IANA)
- NAT 
- LAN 
- Router 
- Subnet mask 
- CIDR 
- Multicast - Broadcast 
<a href="https://imgur.com/FntW68k"><img src="https://i.imgur.com/FntW68k.png" title="source: imgur.com" /></a>
<a href="https://imgur.com/u1eddZe"><img src="https://i.imgur.com/u1eddZe.png" title="source: imgur.com" /></a>
# Distributed computing network protocol 
+ Amdahl's law

+ Parallel computing
    + geographical distribution : WAN, Network Of Workstations/Cluster Of Workstations

+ Parallel computing vs Distributed computing 
<a href="https://imgur.com/0oQG5QJ"><img src="https://i.imgur.com/0oQG5QJ.png" title="source: imgur.com" /></a>

+ Client- server
+ Socket & streams
+ Socket TCP / UDP
+ Multi casting 
+ Streams
+ OSI
+ RPC 
+ RMI : JVM <-> JVM
    + deploy different server 
    + RMI registry 
    
+ CORBA
+ Socket
+ Stream 
+ Java NIO package to perform multitasking 
#### App protocol 
+ IRC bot 
+ SSH 
+ FTP 

### OSI model 
- Datalink & physical : ethernet, FDDI, TokenRing, 
- byte order 

### Debug network program
- log file 
- remote server debug port 
    - SSH port forward

- traffic can be sniffed
- wireshark
- fiddler
- owasp zed attack proxy 


## IoT network programming 
- Connectivity type 
    - wifi: WLAN - IEEE 2.4 ghz / 5ghz radio freq
    - config info in SDcard / USB 
    - connect to computer/ phone (bluetooth)
- ethernet 
- cellular 
    - mobile networks 
    - cellular modem LTE 
- bluetooth   
- IEEE 802.15.4 WPANs 
    -  Zigbee, 6LoWPAN, Thread, ISA100.1, WirelessHART, WiSUN, and MiFi protocols are all based on the IEEE 802.15.4 standard, just to name a few.
- IoT protocol 
- Bandwidth 
- controller 
- security 


# GPU 

# VPU


# Signal processing 

# Image prcessing 



## Metrics 
+ test
+ code coverage 
+ JVM execution threads, CPU, etc

## Multithread application 
- thread dump 
- memory tracking 
- memory leak report plugin 
- detect deadlock 
- cpu & memory profiling 

<a href="https://imgur.com/nPlmfoN"><img src="https://i.imgur.com/nPlmfoN.png" title="source: imgur.com" /></a>
<a href="https://imgur.com/z8BHas0"><img src="https://i.imgur.com/z8BHas0.png" title="source: imgur.com" /></a>
<a href="https://imgur.com/qop5GFz"><img src="https://i.imgur.com/qop5GFz.png" title="source: imgur.com" /></a>




## Stack/ Tools 
- C, C++ 
+ Java : batch, integration 
- Java EE 
+ JConsole 
+ Jtest
+ Findbug 
+ JMH 
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



+ Test 2 different architecture
    + A  computer with an Intel Core i5-5300 CPU with Windows 7 and 16 GB of RAM. This processor has two cores and each core can execute two threads, so we will have four parallel threads.
    + A computer with an AMD A8-640 APU with Windows 10 and 8 GB of RAM. This processor has four cores.


    