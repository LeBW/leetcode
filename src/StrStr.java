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

        int[] next = findNext(needle);

        //start to traverse the string.
        int posH = 0, posN = 0;
        while (posH < haystack.length() && posN < needle.length()) {
            if (haystack.charAt(posH) == needle.charAt(posN)) {
                posH += 1;
                posN += 1;
            }
            else if (posN > 0) {
                posN = next[posN-1];
            }
            else {
                posH += 1;
            }
        }
        if (posN == needle.length())
            return posH - needle.length();
        else
            return -1;

    }

    private int[] findNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        int i = 1, len = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                next[i] = len + 1;
                i++;
                len++;
            }
            else if (len > 0) {
                len = next[len-1];
            }
            else {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }
}
