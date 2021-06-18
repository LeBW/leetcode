package lcof;

/**
 * Offer19. 正则表达式匹配
 * 动态规划（二维）
 * 最重要的是表示出状态转移方程
 * @author LBW
 */
public class Offer19 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {  // 这里要注意从 0 开始，因为 s 为空时，也有可能匹配成功（比如 p 是 a*)
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (i > 0 && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                else {
                    if (i > 0 && (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2))) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
