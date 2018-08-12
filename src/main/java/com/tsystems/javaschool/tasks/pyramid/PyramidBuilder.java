package com.tsystems.javaschool.tasks.pyramid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        int len = inputNumbers.size();

        double x = (Math.sqrt(1 + 8 * len) - 1) / 2;

        if ((x == Math.floor(x)) && !Double.isInfinite(x) && !inputNumbers.contains(null)) {
            System.out.println("Integer!" + x + " " + len);
            inputNumbers.sort(Comparator.naturalOrder());
            int size = (int) x;
            int[][] result = new int[size][size + (size - 1)];
            int indGlobal = 0;
            for (int i = 0 ; i < size ; i++) {
                for (int j = 0 ; j < size + (size - 1) ; j++) {
                    result[i][j] = 0;
                }

                int indStart = ((size + (size - 1)) - (i + (i + 1))) / 2;

                for (int j = indStart ; j < size + (size - 1) - indStart ; j += 2) {
                    result[i][j] = inputNumbers.get(indGlobal);
                    indGlobal++;
                }
            }

            for (int i = 0 ; i < size ; i++) {
                for (int j = 0 ; j < size + (size - 1) ; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }

            return result;

        } else {
            throw new CannotBuildPyramidException();
        }
    }
}
