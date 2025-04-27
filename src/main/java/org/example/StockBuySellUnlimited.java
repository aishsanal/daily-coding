package org.example;

/**
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

 On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

 Find and return the maximum profit you can achieve.



 Example 1:

 Input: prices = [7,1,5,3,6,4]
 Output: 7
 Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 Total profit is 4 + 3 = 7.
 Example 2:

 Input: prices = [1,2,3,4,5]
 Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Total profit is 4.
 Example 3:

 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


 Constraints:

 1 <= prices.length <= 3 * 104
 0 <= prices[i] <= 104
 */
public class StockBuySellUnlimited {
    public static int maxProfit(int[] prices) {
//        int localMaxima, localMinima, profit;
//        localMaxima = prices[0];
//        localMinima = prices[0];
//        profit = 0;
//        for(int i = 0; i < prices.length; i++){
//            if(prices[i] > localMaxima) {
//                localMaxima = prices[i];
//            }
//            if (i == prices.length - 1) {
//                profit += localMaxima - localMinima;
//                break;
//            }
//            if(prices[i+1] < prices[i]){
//                profit += localMaxima - localMinima;
//                localMaxima = prices[i+1];
//                localMinima = prices[i+1];
//            }
//        }

//        int profit = 0;
//
//        for(int i = 0; i < prices.length-1; i++){
//            if(prices[i+1] > prices[i]) {
//                profit += prices[i+1] - prices[i];
//            }
//        }
//        return profit;
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        // dp[i][k] = max profit at the end of day "i" with "k" stocks in hand

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Integer.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Integer.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        }

        return Integer.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{3,4,6,9,2,2,1}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5 }));
    }
}
