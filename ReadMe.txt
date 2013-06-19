Simple implementation of finding common words between 2 files and write them into a 3rd file.

1. What is the maximum number of strings in the input files that your project can handle ? 
Assume that the program was started with -Xmx256M and that each string has on average 8 characters.

Since we load the content of the small file into the Heap; we are limited by the Heap size
allocated in the running VM. If each word has on average of 8 characters (16 Bytes) and the Max available
Heap is 256 x 1024 x 1024 = 268,435,456 Bytes, we could theoretically load in memory a file with an average of 16,777,216 words

2. What would you do to increase this limit ?

Although now we improved the memory footprint of the program storing char[] arrays rather than String objects,
the algorithm apparently is not scalable. To increate the limit I would increase the max allocated Heap size of JVM.
 
3. Is your program efficient ?

Depends on the size of the small file. If one of the 2 files is small enough and can be loaded as whole
into the Heap then the solution is efficient regardless of the size of the second file (at least theoretically). However, 
if we want to calculate common words between huge files i.e TB in size then we would get OutOfMemoryException.

4. What would you do to increase its execution performance ?

This replies to the 2nd question as well, how to make the program more efficient in terms of performance.
I) Split one file into let's say equally fixed chuncks that can be held into Heap. Compare every chunck of first file
with the content of the second file. Emit the common words into your result set. Repeat the process till you examine
the last chunck of first file. 
pros: you avoid outMemException
downsides: you need to re-read the content of the second file

II) Using a distributed processing framework like M/R on top of HDFS.
