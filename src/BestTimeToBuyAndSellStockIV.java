/**
 * 188. Best Time to Buy and Sell Stock IV
 * 动态规划（三维降成二维）.
 * @author LBW
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        // 如果k > n / 2，退化为允许无限次交易
        if (k > n / 2) {
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            }
            return dp[n-1][0];
        }
        //int[][][] dp = new int[n][k+1][2];
        int[][] dp = new int[k+1][2];
        //init
        // for (int j = 0; j < k; j++) {
        //     dp[0][j][0] = 0;
        //     dp[0][j][1] = -prices[0];
        // }
        for (int j = 0; j <= k; j++) {
            dp[j][0] = 0;
            dp[j][1] = -prices[0];
        }
        // fill the dp array.
        // for (int i = 1; i < n; i++) {
        //     dp[i][0][0] = 0;
        //     dp[i][0][1] = Math.max(dp[i-1][0][1], -prices[i]);
        //     for (int j = 1; j <= k; j++) {
        //         dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] + prices[i]);
        //         dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
        //     }
        // }
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                // dp[j][0] = Math.max(dp[j][0], dp[j-1][1] + prices[i]);
                // 这里必须先求[1], 再求[0]，因为求[1]会用到[0]，否则会产生影响
                // 注意第k次买在j-1中，而第k次卖在第k次
                dp[j-1][1] = Math.max(dp[j-1][1], dp[j-1][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1] + prices[i]);
            }
        }

        return dp[k][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2,1,2,0,1};
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        bestTimeToBuyAndSellStockIV.maxProfit(2, prices);
    }
}
