/**
 * Given a string <tt>s</tt>, find the longest palindrome substring in <tt>s</tt>, you may assume that the maximum length of s is 1000.
 *
 * @author LBW
 */
public class LongestPalindrome {
    /**
     * Find the longest palindrome of s.
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
    }
}
