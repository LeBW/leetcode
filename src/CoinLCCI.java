/**
 * 面试题 08.11. Coin LCCI
 * 完全背包问题。
 * 注意状态转移方程，（不需要使用递归计算dp[i][j]）
 * @author LBW
 */
public class CoinLCCI {
    public int waysToChange(int n) {
        // init coins
        int[] coins = new int[]{1, 5, 10, 25};
        // init dp array.
        int[][] dp = new int[4][n+1];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j - coins[i] < 0)  // 此时无法取第i个硬币
                    dp[i][j] = dp[i-1][j];
                else  // 此时可以取第i个硬币。分两种情况：1. 不使用coins[i] 2. 至少使用1个coins[i]
                    dp[i][j] = (dp[i-1][j] + dp[i][j-coins[i]]) % 1000000007;
            }
        }
        return dp[3][n];
    }
}
