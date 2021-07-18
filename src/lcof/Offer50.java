package lcof;

/**
 * Offer 50. 第一个只出现一次的字符
 * 哈希
 * @author LBW
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        for (char c: s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
