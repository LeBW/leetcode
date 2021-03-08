import java.util.Arrays;

/**
 * 两次动态规划。
 * 第一次用来判断是否回文数
 * 第二次用来求最小刀数。
 * 设 dp[i] 代表 s[0, i] 划分成回文串的最小刀数，那么
 * 1. dp[0] = 0;
 * 2. dp[i] = j 从 1 到 i, 且当s[j][i] 是回文串时，dp[j-1] + 1
 * @author LBW
 */
public class PalindromePartitioningII {
    private int ans = Integer.MAX_VALUE;
    // 方法一，回溯，会超时
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j)
                    isPalindrome[i][j] = true;
                else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                }
                else if (s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1]) {
                    isPalindrome[i][j] = true;
                }
                else {
                    isPalindrome[i][j] = false;
                }
            }
        }
        backTrack(s, 0, 0, isPalindrome);
        return ans - 1;
    }

    private void backTrack(String s, int start, int cur, boolean[][] isPalindrome) {
        if (start == s.length()) {
            if (cur < ans)
                ans = cur;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                cur += 1;
                backTrack(s, i + 1, cur, isPalindrome);
                cur -= 1;
            }
        }
    }

    // 方法二：动态规划
    public int minCutTwo(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isPalindrome[i], true);
        }
        // 第一次动态规划，用来判断s[i, j]是不是回文数
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1];
            }
        }
        // 第二次动态规划，用来判断将 s 拆分成回文数的最小刀数
        int[] dp = new int[n];  // dp[i] 代表 s[0, i] 拆分成回文数的最小刀数
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (isPalindrome[0][i])
                dp[i] = 0;
            else {
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
