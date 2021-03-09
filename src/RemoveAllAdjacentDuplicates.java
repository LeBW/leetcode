/**
 * 1047. Remove All Adjacent Duplicates In String
 * 栈
 * @author LBW
 */
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String S) {
        StringBuilder builder = new StringBuilder();
        int n = S.length();
        builder.append(S.charAt(0));
        for (int i = 1; i < n; i++) {
            if (builder.length() > 0 && S.charAt(i) == builder.charAt(builder.length() - 1)) {
                builder.deleteCharAt(builder.length() - 1);
            }
            else {
                builder.append(S.charAt(i));
            }
        }
        return builder.toString();
    }
}
