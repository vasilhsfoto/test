Simple implementation of finding common words between 2 files and write them into a 3rd file.

1. Since we load the content of the small file into the Heap; we are limited by the Heap size
allocated in the running VM. If each word (on average) has 6 characters (6 Bytes) and the available
Heap is 256 x 1024 x 1024 Bytes we can load in memory a file with an average of 44739242 words

2. First of all, I would try to vertically increase the performance. That is increasing the heap size of the machine the VM 
-Xmx1024M. However, this has an upper limit the max available RAM of the node the application is running on
 
3. Depends on the size of the small file. If one of the 2 files is small enough and can be loaded as whole
into the Heap then the solution is efficient regardless of the size of the second file (at least theoriticaly). However, 
if we want to calculate common words between huge files i.e TB in size then we would get OutOfMemoryException.

4. This replies to the 3rd question as well, how to make the program more efficient in terms of performance.  
I) One solution, is to load parts of the smallest file into memory (so to avoid outOfMem exception) and compare 
them against the second file. Then you repeat the process until you have examined all the content of the smallest file.
This way you need to read the second file more than once.

II) Using a framework for parallel processing of vast amount of data. like Map Reduce (M/R) on top of
Hadoop. Without going into details of how to solve the problem utilizing M/R; the solution given is equal to Map Side join.     
A reduce side join would be an good fit in case we want to deal with vast volumes of Data.