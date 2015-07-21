package com.leetcode.dynamicprogramming;

/**
 * Created on 7/20/15.
 * <p/>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p/>
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePath {
    public int findUniquePaths(int m, int n) {
        int[][] r = new int[m][n];
        return recurse(r, m, n);
    }

    private int recurse(int[][] r, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        //check if this is already computed, if so, return the value.
        if (r[m][n] > 0) {
            return r[m][n];
        }
        if ((m == 0) && (n == 0)) {
            return 1;
        }
        //compute the value for m,n and store it. // same as fibonacci
        r[m][n] = recurse(r, m - 1, n) + recurse(r, m, n - 1);
        return r[m][n];
    }

    /*
    Another solution - Space Efficient

    The intuitive approach is to create a grid with size m*n and calculate the possible path at each cell based on the
    sum of the cell above and cell to the left. However with some optimization we can reduce the grid to a single row with
    the length n and update the integer at each index based on the sum of previous index and its original value, thus
    reduce the space complexity to a single row.

    1 1 1
    1 2 3
    1 3 4
    1 4 5 .. and so on.
     */

    public int findUniquePathsSpaceEfficient(int m, int n) {
        // choose smaller of them
        if (m == 0 || n == 0)
            return 0;
        int low = (m <= n) ? m : n;
        int high = (m > n) ? m : n;
        int[] r = new int[low];

        for (int i = 0; i < high; i++) {
            for (int j = 0; j < low; j++) {
                // first rows are taken as 1 (one path to that point)
                if (i == 0 || j == 0)
                    r[j] = 1;
                else
                    r[j] += r[j - 1];
            }
        }
        return r[low - 1];
    }
}
