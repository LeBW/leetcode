/**
 * 467. Unique Substrings in Wraparound String
 * 动态规划+字典
 * @author LBW
 */
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0)
            return 0;
        int[] dp = new int[26];
        dp[p.charAt(0) - 'a'] = 1;
        int consecutive = 1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i) - p.charAt(i-1) == -25) {
                consecutive += 1;
                dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], consecutive);
            }
            else {
                consecutive = 1;
                dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], consecutive);
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += dp[i];
        }
        return res;
    }
}
