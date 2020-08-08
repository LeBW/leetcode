/**
 * 72. Edit Distance
 * 最短编辑距离。 动态规划经典题目
 * @author LBW
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        // init
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }
        // fill the dp array.
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1), dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[l1][l2];
    }
}
