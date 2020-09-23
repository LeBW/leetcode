/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * @author LBW
 */
public class BestTimeToBASStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);  // 因为卖出后会有一天冻结期，因此算的时候，要从i-2天就卖掉了
        }
        return dp[n-1][0];
    }

    /**
     * dp[n-1][3]，其中第二维表示三个状态。
     * 0：手里是现金
     * 1：手里是股票
     * 2：手里是现金（但是冻结）
     * 所以重点在于如何列出状态转移方程（可以利用状态机的概率，画图）
     */
    public int maxProfitTwo(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] - prices[i]);
            dp[i][2] = dp[i-1][0];  // 如果第i天是冻结期，说明第i-1天发生了卖出，所以是[0]的状态
        }
        return Math.max(dp[n-1][0], dp[n-1][2]);
    }
}
