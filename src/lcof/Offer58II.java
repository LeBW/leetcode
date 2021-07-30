package lcof;

/**
 * Offer 58 - II. 左旋转字符串
 * @author LBW
 */
public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        builder.append(s.substring(n));
        builder.append(s, 0, n);
        return builder.toString();
    }
}
