package com.tsystems.javaschool.tasks.pyramid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PyramidBuilderTest {

    private PyramidBuilder pyramidBuilder = new PyramidBuilder();

    @Test
    public void buildPyramid0() {
        // given
        List<Integer> input = Arrays.asList(1, 15, 2);
        int[][] expected = new int[][]{
                {0, 1, 0},
                {2, 0, 15}};

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert
        comparePyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid() {
        // given
        List<Integer> input = Arrays.asList(1, 3, 2, 9, 4, 5);
        int[][] expected = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 2, 0, 3, 0},
                {4, 0, 5, 0, 9}};

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert
        comparePyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid3() {
        // given
        List<Integer> input = Arrays.asList(1, 3, 2, 9, 4, 5, 10, 8, 7, 6);
        int[][] expected = new int[][]{
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 2, 0, 3, 0, 0},
                {0, 4, 0, 5, 0, 6, 0},
                {7, 0, 8, 0, 9, 0, 10}};

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert
        comparePyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid4() {
        // given
        List<Integer> input = Arrays.asList(11, 1, 12, 3, 2, 13, 9, 4, 5, 14, 10, 8, 7, 15, 6);
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 3, 0, 0, 0},
                {0, 0, 4, 0, 5, 0, 6, 0, 0},
                {0, 7, 0, 8, 0, 9, 0, 10, 0},
                {11, 0, 12, 0, 13, 0, 14, 0, 15}
        };

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert
        comparePyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid5() {
        // given
        List<Integer> input = Arrays.asList(11, 1, 21, 12, 3, 16, 2, 13, 9, 4, 17, 5, 14, 10, 18, 8, 7, 19, 15, 6, 20);
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 4, 0, 5, 0, 6, 0, 0, 0},
                {0, 0, 7, 0, 8, 0, 9, 0, 10, 0, 0},
                {0, 11, 0, 12, 0, 13, 0, 14, 0, 15, 0},
                {16, 0, 17, 0, 18, 0, 19, 0, 20, 0, 21}
        };

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert
        comparePyramids(expected, pyramid);
    }


    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid1() {
        // given
        List<Integer> input = Arrays.asList(1, 3, 2, 9, 4, null);

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert (exception)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid2() {
        // given
        List<Integer> input = Arrays.asList(1, 3, 2, 9, 4, 5, null);

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert (exception)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid6() {
        // given
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i < 256; i++) {
            input.add(i);
        }

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert (exception)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid7() {
        // given
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            input.add(i);
        }

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert (exception)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid8() {
        // given
        List<Integer> input = Collections.nCopies(Integer.MAX_VALUE - 1, 0);

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert (exception)
    }

    @Test
    public void buildPyramid9() {
        // given
        List<Integer> input = Arrays.asList(1, 3, 2, 0, 4, 5);
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 2, 0},
                {3, 0, 4, 0, 5}};

        // run
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // assert
        comparePyramids(expected, pyramid);
    }

    private void comparePyramids(int[][] expected, int[][] pyramid) {
        Assert.assertEquals("Amount of rows is different.", expected.length, pyramid.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], pyramid[i]);
        }
    }

}