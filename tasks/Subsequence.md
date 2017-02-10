# Subsequence #
[Back to readme](/README.md)

### General description ###

Given two sequences {X} and {Y} of arbitrary elements (java.lang.Object).

Determine whether {X} can be built by removing some elements from {Y} without changing the order.

### Input and expected output ###
* Input : List X and List Y
* Output : boolean, true if {X} can be built from {Y}, false otherwise

### Examples ###
{X} : "A", "B", "C", "D"

{Y} : ~~"BD"~~, "A", ~~"ABC"~~, "B", ~~"M"~~, ~~"D"~~, ~~"M"~~,"C", ~~"DC"~~, "D"

```java
Subsequence s = new SubsequenceImpl();
boolean b = s.find(Arrays.asList("A", "B", "C", "D"),
 Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D"));
System.out.println(b); // Result: true
```