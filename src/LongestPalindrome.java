/**
 * Given a string <tt>s</tt>, find the longest palindrome substring in <tt>s</tt>, you may assume that the maximum length of s is 1000.
 *
 * @author LBW
 */
public class LongestPalindrome {

    /**
     * Method 1: Dynamic Programming
     */
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0)
            return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];  //default to false.
        int max = 1;
        int start = 0;
        for (int i = 0; i < len-1; i++) {
            dp[i][i] = true;
            dp[i+1][i] = true;
        }
        dp[len-1][len-1] = true;

        for (int k = 1; k <= len; k++) {
            for (int i = 0; i + k < len; i++) {
                if (s.charAt(i) == s.charAt(i+k) && dp[i+1][i+k-1]) {
                    dp[i][i+k] = true;
                    if (k+1 > max) {
                        max = k+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+max);
    }

    /**
     * Method 2: 中心扩展
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        int center = 0;
        for (int i = 0; i < len; i++) {
            int l1 = palindromeFrom(s, len, i, i);
            int l2 = palindromeFrom(s, len, i, i+1);
            int ml = Math.max(l1, l2);
            if  (ml > max) {
                max = ml;
                center = i;
            }
        }
        int left = center - (max - 1) / 2;
        int right = center + max / 2;
        return s.substring(left, right+1);
    }

    /**
     * find the longest palindrome of s from center: (left + right) / 2.
     */
    private int palindromeFrom(String s, int len, int left, int right) {
        if (left == right) {
            int result = 1;
            left--;right++;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                result += 2;
                left--;right++;
            }
            return result;
        }
        else {
            int result = 0;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                result += 2;
                left--;right++;
            }
            return result;
        }
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindromeDP("asdfdsa"));
    }
}
