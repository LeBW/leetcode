import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * 动态规划 + 回溯
 * @author LBW
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];  // 用动态规划判断s[i, j] 是不是回文串
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j || (j - i == 1 && s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;
                }
                else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        List<String> cur = new ArrayList<>();
        backTrack(s, 0, result, cur, dp);  //  用回溯找出所有的符合条件的子串
        return result;
    }

    private void backTrack(String s, int idx, List<List<String>> res, List<String> cur, boolean[][] dp) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                cur.add(s.substring(idx, i + 1));
                backTrack(s, i + 1, res, cur, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
