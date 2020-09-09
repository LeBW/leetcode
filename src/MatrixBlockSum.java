/**
 * 动态规划：dp[i][j]用来表示从nums[0][0]到nums[i-1][j-1]的和。
 * 为了方便计算，这里初始化了dp[m+1][n+1].
 * 时间复杂度：O(mn).
 * @author LBW
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        //create a cumulative sum matrix dp[i][j]
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        // fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
            }
        }
        // use the array to compute the matrix block.
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int i1 = i - K >= 0 ? i - K : 0;
                int j1 = j - K >= 0 ? j - K : 0;
                int i2 = i + K < m ? i + K : m - 1;
                int j2 = j + K < n ? j + K : n - 1;
                res[i][j] = dp[i2+1][j2+1] + dp[i1][j1] - dp[i2+1][j1] - dp[i1][j2+1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] max = new int[][]{{67, 64, 78}, {99, 98, 38}, {82, 46, 46}, {6, 52, 55}, {55, 99, 45}};
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum();
        matrixBlockSum.matrixBlockSum(max, 3);
    }
}
