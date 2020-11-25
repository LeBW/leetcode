import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1370. Increasing Decreasing String
 * @author LBW
 */
public class IncreasingDecreasingString {
    /**
     * 方法一，先排序，然后用指针模拟，左右遍历，直到所有元素都访问到。
     */
    public String sortString(String s) {
        List<Character> l = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            l.add(s.charAt(i));
        }
        Collections.sort(l);
        boolean[] isUsed = new boolean[l.size()];
        StringBuilder res = new StringBuilder();
        int idx = 0, step = 1;
        for (int i = 0;  i < s.length(); i++) {
            char c = l.get(idx);
            res.append(c);
            isUsed[idx] = true;
            if (i == s.length() - 1)
                break;
            // 找到下一个idx
            idx += step;
            while (idx >= 0 && idx < l.size() && (l.get(idx) == c || isUsed[idx])) {
                idx += step;
            }
            if (idx < 0 || idx >= l.size()) {  // 如果过界，反向进行
                step = step == 1 ? -1 : 1;
                idx += step;
                while (isUsed[idx]) {
                    idx += step;
                }
            }
        }
        return res.toString();
    }

    /**
     * 方法二，哈希，桶排序的思想。
     */
    public String sortStringTwo(String s) {
        int[] bucket = new int[26];
        char[] cs = s.toCharArray();
        for (char c: cs) {
            bucket[c - 'a'] += 1;
        }
        int count = 0;
        StringBuilder res = new StringBuilder();
        while (count < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] > 0) {
                    res.append((char)('a' + i));
                    bucket[i] -= 1;
                    count += 1;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (bucket[i] > 0) {
                    res.append((char)('a' + i));
                    bucket[i] -= 1;
                    count += 1;
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "leetcode";
        IncreasingDecreasingString increasingDecreasingString = new IncreasingDecreasingString();
        increasingDecreasingString.sortString(str);
    }
}
