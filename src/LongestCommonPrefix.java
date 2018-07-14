/**
 * @author LBW
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (isSame(strs, i)) {
            builder.append(strs[0].charAt(i));
            i++;
        }
        return builder.toString();
    }

    private boolean isSame(String[] strs, int i) {
        for (int j = 0; j < strs.length; j++) {
            if (strs[j].length() <= i)
                return false;
        }
        boolean result = true;

        char target = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
            if (target != strs[j].charAt(i)) {
                return false;
            }
        }
        return result;
    }
}
