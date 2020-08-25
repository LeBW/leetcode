/**
 * 375. Guess Number Higher or Lower II
 * @author LBW
 * 动态规划
 * 有点类似887，高楼扔鸡蛋。
 * dp[i][j] 表示从i到j所需要的最小开销。
 * 从i到j依次取k，计算 `k + max(dp[i][k-1], dp[k+1, j])`，取其中最小值即是dp[i][j].
 * 另外，需要注意求dp[i][j]的顺序
 */
public class GuessNumberHorLII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 1; i--) {
                // compute dp[i][j]
                dp[i][j] = Math.min(i + dp[i+1][j], j + dp[i][j-1]);
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k-1], dp[k+1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
