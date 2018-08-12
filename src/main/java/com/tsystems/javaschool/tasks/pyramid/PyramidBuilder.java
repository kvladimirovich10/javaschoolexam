package com.tsystems.javaschool.tasks.pyramid;

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

        double requiredNumberOfElements = (Math.sqrt(1 + 8 * len) - 1) / 2;

        if ((requiredNumberOfElements == Math.floor(requiredNumberOfElements)) &&
                !Double.isInfinite(requiredNumberOfElements) &&
                !inputNumbers.contains(null)) {

            inputNumbers.sort(Comparator.naturalOrder());

            int size_i = (int) requiredNumberOfElements;
            int size_j = size_i + (size_i - 1);
            int[][] result = new int[size_i][size_j];
            int indGlobal = 0;

            for (int i = 0 ; i < size_i ; i++) {
                for (int j = 0 ; j < size_j ; j++) {
                    result[i][j] = 0;
                }

                int indStart = (size_j - (2 * i + 1)) / 2;

                for (int j = indStart ; j < size_j - indStart ; j += 2) {
                    result[i][j] = inputNumbers.get(indGlobal);
                    indGlobal++;
                }
            }

            return result;

        } else {
            throw new CannotBuildPyramidException();
        }
    }
}
