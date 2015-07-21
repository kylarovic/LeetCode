package com.leetcode.dynamicprogramming;

/**
 * Created on 7/20/15.
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
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
}
