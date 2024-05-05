/**
 * 647. Palindromic Substrings
 * 中心扩散
 * @author LBW
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length(), i = 0;
        int res = 0;
        int left, right;
        while (i < n) {
            // i as center
            res += 1;
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                res += 1;
                left -= 1;
                right += 1;
            }
            // [i, i+1] as center
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                res += 1;
                left -= 1;
                right += 1;
            }
            i += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        palindromicSubstrings.countSubstrings("fdsklf");
    }
}
