/**
 * 474. Ones and Zeros
 * 动态规划，类似背包问题。
 * dp[k][i][j]：前k个字符串，用i个0，j个1，组成的最大数目
 * @author LBW
 */
public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int k = 0; k <= len; k++) {
            int num0 = 0, num1 = 0;
            if (k > 0) {
                for (char c: strs[k-1].toCharArray()) {
                    if (c == '0')
                        num0 += 1;
                    else
                        num1 += 1;
                }
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (k == 0) {
                        dp[k][i][j] = 0;
                    }
                    else {
                        if (i >= num0 && j >= num1)
                            dp[k][i][j] = Math.max(dp[k-1][i][j], dp[k-1][i-num0][j-num1] + 1);
                        else
                            dp[k][i][j] = dp[k-1][i][j];
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}
