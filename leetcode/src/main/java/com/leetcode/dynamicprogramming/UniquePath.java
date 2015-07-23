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

    /*
    Follow up for "Unique Paths":

    Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    For example,
    There is one obstacle in the middle of a 3x3 grid as illustrated below.
    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    The total number of unique paths is 2.

    Note: m and n will be at most 100
     */
    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] r = new int[2][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    r[i%2][j] = (a[i][j] == 1) ? 0 : 1;
                }else if(i == 0) {
                    r[i%2][j] = (a[i][j] == 1) ? 0 : r[Math.abs(i%2)][j-1];
                }else if(j == 0) {
                    r[i%2][j] = (a[i][j] == 1) ? 0 : r[Math.abs((i%2-1))][j];
                }else {
                    r[i%2][j] = (a[i][j] == 1) ? 0 : r[Math.abs((i%2-1))][j] + r[Math.abs(i%2)][j-1];
                }
            }
        }
        return r[Math.abs(m%2 -1 )][n-1];
    }
}
