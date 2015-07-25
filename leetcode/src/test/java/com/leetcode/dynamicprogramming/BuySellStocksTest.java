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
    }

    @Test public void testKadane() throws Exception {
        int[] test = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int expected = 6;
        BuySellStocks b = new BuySellStocks();
        int actual = b.kadane(test);

        Assert.assertTrue(expected == actual);
    }
}