package com.tsystems.javaschool.tasks.duplicates;

import org.junit.Test;

import java.io.File;

public class DuplicateFinderTest {

    private DuplicateFinder duplicateFinder = new DuplicateFinder();

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        //run
        duplicateFinder.process(null, new File("a.txt"));

        //assert : exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        //run
        duplicateFinder.process(new File("a.txt"), null);

        //assert : exception
    }


}