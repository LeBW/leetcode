/**
 * 518. Coin Change 2
 * 动态规划。完全背包问题
 *
 * @author LBW
 */
public class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // dp[i-1][j] 指不用coins[i-1]时的数量
                    // dp[i][j-coins[i-1]] 指至少使用一个coins[i-1]后，可能的数量。
                    // 两者相加即可.
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
}
