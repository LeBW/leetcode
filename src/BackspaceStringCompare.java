/**
 * 844. Backspace String Compare
 * @author LBW
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        String s1 = func(S);
        String s2 = func(T);
        return s1.equals(s2);
    }

    private String func(String str) {
        char[] s = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c: s) {
            if (c == '#' && builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            else if (c != '#') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
