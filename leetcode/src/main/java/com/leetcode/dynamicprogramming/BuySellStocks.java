package com.leetcode.dynamicprogramming;

/**
 * Created on 7/24/15.
 */
public class BuySellStocks {

    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.
     */

    public int maxProfitPurchaseOnce(int[] prices) {
        int[] d = new int[prices.length];//build difference array
        for (int i = 1; i < prices.length; i++) {
            d[i] = prices[i] - prices[i - 1];
        }
        //apply kadane's algorithm
        return kadane(d);
    }

    public int kadane(int[] d) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 0; i < d.length; i++) {
            maxCur = Math.max(0, maxCur + d[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
