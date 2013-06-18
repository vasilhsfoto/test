Simple implementation of finding common words between 2 files and write them into a 3rd file.

1. What is the maximum number of strings in the input files that your project can handle ? 
Assume that the program was started with -Xmx256M and that each string has on average 8 characters.

Since we load the content of the small file into the Heap; we are limited by the Heap size
allocated in the running VM. If each word has on average 8 characters (16 Bytes) and the Max available
Heap is 256 x 1024 x 1024 = 268,435,456 Bytes, we could theoretically load in memory a file with an average of 16,777,216 words

2. What would you do to increase this limit ?

Although now we improved the memory footprint of the program storing char[] arrays rather than String objects, 
the algorithm apparently is not scalable.   
 
3. Is your program efficient ?

Depends on the size of the small file. If one of the 2 files is small enough and can be loaded as whole
into the Heap then the solution is efficient regardless of the size of the second file (at least theoretically). However, 
if we want to calculate common words between huge files i.e TB in size then we would get OutOfMemoryException.

4. What would you do to increase its execution performance ?

This replies to the 3rd question as well, how to make the program more efficient in terms of performance.  
I) One solution, is to load parts of the smallest file into memory (so to avoid outOfMem exception) and compare 
them against the second file. Then you repeat the process until you have examined all the content of the smallest file.
This way you need to read the second file more than once.

II) Using a framework for parallel processing of vast amount of data. like Map Reduce (M/R) on top of
Hadoop. Without going into details of how to solve the problem utilizing M/R; the solution given is equal to Map Side join.     
A reduce side join would be an good fit in case we want to deal with vast volumes of Data.