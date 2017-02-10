# Duplicates #
[Back to readme](/README.md)

### General description ###

Given input file with text lines. Create a file with all lines from the first file with following conditions:
 
 * All lines are sorted
 * At the end of each line put a number in square bracket which displays the amount of the line repetition in input file
 * Output file shouldn't have duplicated lines even if the input file has

Not guaranteed that the input files exist. In case the output file is missing it's to be created.
If the output file exists the result of processing is to be added to it, the file shouldn't be overwritten.

### Input and expected output ###
* Input : Input file with text lines, output file to write the result to
* Output : true iff the processing finished successfully, false otherwise

### Examples ###
```java
DuplicateFinder d = new DuplicateFinderImpl(); 
d.process(new File("a.txt"), new File("b.txt"));

a.txt
ccc
ddd
bbb
ddd
ddd
aaa

b.txt
aaa[1]
bbb[1]
ccc[1]
ddd[3]
```