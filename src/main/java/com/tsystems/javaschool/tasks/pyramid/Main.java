package com.tsystems.javaschool.tasks.pyramid;import java.util.Arrays;import java.util.List;public class Main {    public static void main(String[] args) {        PyramidBuilder pyramidBuilder = new PyramidBuilder();        List<Integer> input = Arrays.asList(11, 1, 21, 12, 3, 16, 2, 13, 9, 4, 17, 5, 14, 10, 18, 8, 7, 19, 15, 6,20);        pyramidBuilder.buildPyramid(input);    }}