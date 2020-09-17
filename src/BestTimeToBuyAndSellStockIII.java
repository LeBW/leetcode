/**
 * 123. Best Time to Buy and Sell Stock III
 * @author LBW
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }
        return Math.max(Math.max(dp[n-1][0], dp[n-1][2]), dp[n-1][4]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        BestTimeToBuyAndSellStockIII bestTimeToBuyAndSellStockIII = new BestTimeToBuyAndSellStockIII();
        bestTimeToBuyAndSellStockIII.maxProfit(prices);
    }
}
