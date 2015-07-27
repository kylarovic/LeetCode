package com.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class BuySellStocksTest {
    @Test public void testMaxProfitPurchaseOnce() throws Exception {
        int[] test = { 6, 1, 3, 2, 4, 7 };
        int expected = 6;
        BuySellStocks b = new BuySellStocks();
        int actual = b.maxProfitPurchaseOnce(test);

        Assert.assertTrue(expected == actual);

        actual = b.maxProfitPurchaseOnce2(test);
        Assert.assertTrue(expected == actual);
    }

    @Test public void testMaxProfitPurchaseAnyNumberOfTimes() throws Exception {
        int[] test = { 6, 1, 3, 2, 4, 7 };
        int expected = 7;
        BuySellStocks b = new BuySellStocks();
        int actual = b.maxProfitPurchaseAnyNumberOfTimes(test);

        Assert.assertTrue(expected == actual);
    }

    @Test public void testMaxProfitPurchaseNtimes() throws Exception {
        int[] test = { 6, 1, 3, 2, 4, 7 };
        int expected = 7;
        BuySellStocks b = new BuySellStocks();
        int actual = b.maxProfitPurchaseNtimes(test);
    }
}