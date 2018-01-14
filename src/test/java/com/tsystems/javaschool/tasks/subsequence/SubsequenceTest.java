package com.tsystems.javaschool.tasks.subsequence;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class SubsequenceTest {

    private Subsequence subsequence = new Subsequence();

    @Test
    public void find0() {
        //given
        List x = Stream.of(1, 3, 5, 7, 9).collect(toList());
        List y = Stream.of(10, 1, 2, 3, 4, 5, 7, 9, 20).collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertTrue(result);
    }

    @Test
    public void find00() {
        //given
        List x = Stream.of(1, 3, 5, 7, 9).collect(toList());
        List y = Stream.of(10, 1, 2, 3, 4, 3, 5, 7, 9, 20).collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertTrue(result);
    }

    @Test
    public void find() {
        //given
        List x = Stream.of(1, 3, 5, 7, 9).collect(toList());
        List y = Stream.of(1, 2, 3, 4, 5, 7, 9, 20).collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertTrue(result);
    }

    @Test
    public void find1() {
        //given
        List x = Stream.of(1, 2, 3, 4, 5, 7, 9, 20).collect(toList());
        List y = Stream.of(1, 3, 5, 7, 9).collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertFalse(result);
    }

    /**
     * Y contains X, but in different order.
     */
    @Test
    public void find2() {
        //given
        List x = Stream.of(3, 9, 1, 5, 7).collect(toList());
        List y = Stream.of(1, 2, 3, 4, 5, 7, 9, 20).collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertFalse(result);
    }

    /**
     * Y contains X, but in different order.
     */
    @Test
    public void find3() {
        //given
        List x = Stream.of("B", "A", "D", "C").collect(toList());
        List y = Stream.of("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D").collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertFalse(result);
    }

    @Test
    public void find4() {
        //given
        List x = Stream.of("B", "A", "D", "C").collect(toList());
        List y = Stream.of("BD", "ABC", "B", "M", "D", "M", "C", "DC", "D").collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertFalse(result);
    }

    @Test
    public void find5() {
        //given
        List x = new ArrayList();
        List y = Stream.of("BD", "ABC", "B", "M", "D", "M", "C", "DC", "D").collect(toList());

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertTrue(result);
    }

    @Test
    public void find6() {
        //given
        List x = new ArrayList();
        List y = new ArrayList();

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertTrue(result);
    }

    @Test
    public void find7() {
        //given
        List x = Stream.of("B", "A", "D", "C").collect(toList());
        List y = new ArrayList();

        //run
        boolean result = subsequence.find(x, y);

        //assert
        Assert.assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void find8() {
        //given
        List x = null;
        List y = new ArrayList();

        //run
        subsequence.find(x, y);

        //assert: exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void find9() {
        //given
        List x = new ArrayList();
        List y = null;

        //run
        subsequence.find(x, y);

        //assert: exception
    }


}