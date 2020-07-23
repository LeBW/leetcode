/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * 回溯
 * @author LBW
 */
public class TheKthLexicographicalString {
    private int count = 0;
    private final char[] candidates = new char[]{'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        count = 0;
        StringBuilder builder = new StringBuilder();
        return dfs(n, k, builder);
    }

    private String dfs(int n, int k, StringBuilder builder) {
        int len = builder.length();
        if (len == n) {
            count += 1;
            if (count == k) {
                return builder.toString();
            }
            else
                return "";
        }
        if (len == 0) {
            for (char c: candidates) {
                builder.append(c);
                String str = dfs(n, k, builder);
                if (!str.equals("")) {
                    return str;
                }
                builder.deleteCharAt(len);
            }
        }
        else {
            for (char c: candidates) {
                if (c == builder.charAt(len - 1))
                    continue;
                builder.append(c);
                String str = dfs(n, k, builder);
                if (!str.equals("")) {
                    return str;
                }
                builder.deleteCharAt(len);
            }
        }
        return "";
    }
}
