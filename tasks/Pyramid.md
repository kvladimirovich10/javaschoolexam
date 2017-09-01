# Pyramid builder #

[Back to readme](/README.md)

### General description ###

Your solution should build a pyramid from given input list of integer values.
Numbers are to be sorted ascending from top to bottom, from left to right.

Empty spaces are to be filled with zeros. 
In order to make the pyramid symmetric input numbers should alternate with zeros.

For example, for input A={2, 4, 3, 5, 6, 1} the pyramid will look like:  
        [0,0,**1**,0,0]  
        [0,**2**,0,**3**,0]  
        [**4**,0,**5**,0,**6**]  

Refer to unit-tests for more examples.

### Input and expected output ###
* Input : List with integer values
* Output : 2D array with the pyramid or CannotBuildPyramidException if it's not possible to build one