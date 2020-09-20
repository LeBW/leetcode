/**
 * 5521. Maximum Non Negative Product in a Matrix
 * 动态规划。
 * dp[i][j][0]：到[i, j]时的最小值
 * dp[i][j][1]：到[i, j]时的最大值.
 * @author LBW
 */
public class MaximumNonNegativeProduct {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        // init
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i-1][0][0] * grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j-1][0] * grid[0][j];
        }
        // fill the array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.min(Math.min(dp[i-1][j][0] * grid[i][j], dp[i-1][j][1] * grid[i][j]), Math.min(dp[i][j-1][0] * grid[i][j], dp[i][j-1][1] * grid[i][j]));
                dp[i][j][1] = Math.max(Math.max(dp[i-1][j][0] * grid[i][j], dp[i-1][j][1] * grid[i][j]), Math.max(dp[i][j-1][0] * grid[i][j], dp[i][j-1][1] * grid[i][j]));
            }
        }
        if (dp[m-1][n-1][1] >= 0) {
            return (int)(dp[m-1][n-1][1] % (long)(1e9 + 7));
        }
        else {
            return -1;
        }
    }
}
