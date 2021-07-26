package lcof;

/**
 * Offer 58. 翻转单词顺序
 * @author LBW
 */
public class Offer58 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");   // 这里用 \\s 来匹配 一到多个空格的情况
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i > 0; i--) {
            builder.append(strs[i]);
            builder.append(" ");
        }
        builder.append(strs[0]);
        return builder.toString();
    }

    public static void main(String[] args) {
        Offer58 offer58 = new Offer58();
        String res = offer58.reverseWords(" hello world! ");
        System.out.println(res);
    }
}
