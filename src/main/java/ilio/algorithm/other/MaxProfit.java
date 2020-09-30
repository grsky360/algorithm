package ilio.algorithm.other;

/**
 * @Author hyia
 * @url https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @url https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{1, 2, 3, 4, 5}));
    }
}
