/**
 * 122. Best Time to Buy and Sell Stock II
 * 二位状态数组：
 * dp[i][0]: 第i天，手里拿现金时的最大收益
 * dp[i][1]: 第i天，手里拿股票时的最大收益
 * @author LBW
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
