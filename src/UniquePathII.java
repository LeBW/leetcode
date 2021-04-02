/**
 * 63. Unique Path II
 * @author LBW
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int idx = 0;
        while (idx < n && obstacleGrid[0][idx] != 1) {
            dp[0][idx] = 1;
            idx += 1;
        }
        while (idx < n) {
            dp[0][idx] = 0;
            idx += 1;
        }
        idx = 0;
        while (idx < m && obstacleGrid[idx][0] != 1) {
            dp[idx][0] = 1;
            idx += 1;
        }
        while (idx < m) {
            dp[idx][0] = 0;
            idx += 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
