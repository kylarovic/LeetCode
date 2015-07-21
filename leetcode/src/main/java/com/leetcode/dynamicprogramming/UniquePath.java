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

        return recurse(m, n);
    }

    public int recurse(int m, int n) {
        return 0;
    }
}
