package com.tsystems.javaschool.tasks.subsequence;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {

        if (x == null || y == null)
            throw new IllegalArgumentException();
        else if (x.size() > y.size())
            return false;
        else {
            if (x.isEmpty())
                return true;

            Iterator xIterator = x.iterator();
            Object curX = xIterator.next();

            for (Object yObj:y) {
                if (yObj.equals(curX)) {
                    if (!xIterator.hasNext())
                        return true;
                    else
                        curX = xIterator.next();
                }
            }
            return false;
        }
    }
}