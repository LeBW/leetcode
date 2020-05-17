/**
 * <a href=https://leetcode-cn.com/problems/implement-strstr/description/>
 * Click to see online description
 * </a>
 * <br>
 * Implement KMP algorithm.
 * @author LBW
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        // get the array {next}.
        int[] next = getNext(needle);
        // start to traverse the string by i. (j is used to indicate index of needle)
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else if (j > 0) {
                j = next[j-1];
            }
            else {  // j = 0
                i++;
            }
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }

    /**
     * Get next array.
     * @param needle
     * @return next
     */
    private int[] getNext(String needle) {
        int len = needle.length();
        int[] next = new int[len];
        next[0] = 0;
        int i = 1, j = 0;
        while (i < len) {
            if (needle.charAt(i) == needle.charAt(j)) {
                next[i] = j + 1;
                i++;
                j++;
            }
            else if (j == 0) {
                next[i] = 0;
                i++;
            }
            else {  // j > 0
                 j = next[j-1];  // This step is really important! j indicates candidates of next.
            }
        }
        return next;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        strStr.strStr("hello", "ll");
    }
}
