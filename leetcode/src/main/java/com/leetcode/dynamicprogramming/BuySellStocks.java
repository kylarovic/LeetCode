package com.leetcode.dynamicprogramming;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;

/**
 * Created on 7/24/15.
 */
public class BuySellStocks {

    //##########################PURCHASE ONLY ONCE##############################
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.
     */
    // works when difference is given - using kadane
    public int maxProfitPurchaseOnce(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    // doesn't work when difference is given
    public int maxProfitPurchaseOnce2(int[] prices) {
        int min = 0, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - profit);
        }
        return profit;
    }

    //######################PURCHASE ANY NUMBER OF TIMES#########################
    /*
    Just ignore the ones that decrease and pick all the increasing ones.
    In case of difference, just sum all positive difference.
     */
    public int maxProfitPurchaseAnyNumberOfTimes(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i])
                total += prices[i + 1] - prices[i];
        }
        return total;
    }

    //######################PURCHASE N NUMBER OF TIMES#############################
    public int maxProfitPurchaseNtimes(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        ArrayList<Integer> maxPrevious = new ArrayList<Integer>();
        maxPrevious.add(0);
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
            if(maxCur != 0) {
                maxPrevious.set(maxPrevious.size()-1, maxSoFar);
            }else {
                maxPrevious.add(maxSoFar);
            }
        }
        System.out.println(maxPrevious);
        return maxSoFar;
    }
}
