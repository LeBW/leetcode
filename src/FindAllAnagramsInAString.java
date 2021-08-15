import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams In a String
 * 滑动窗口，哈希
 * 要注意边界情况
 * @author LBW
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] pcount = new int[26];
        for (char c: p.toCharArray()) {
            pcount[c - 'a'] += 1;
        }
        List<Integer> res = new ArrayList<>();
        int i = 0, j = -1;
        int[] count = new int[26];
        while (j < p.length() - 1) {
            j += 1;
            count[s.charAt(j) - 'a'] += 1;
        }
        do {
            if (equals(count, pcount)) {
                res.add(i);
            }
            count[s.charAt(i) - 'a'] -= 1;
            i += 1;
            j += 1;
            if (j < s.length()) {
                count[s.charAt(j) - 'a'] += 1;
            }
        } while (j < s.length());
        return res;
    }

    private boolean equals(int[] count, int[] pcount) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != pcount[i]) {
                return false;
            }
        }
        return true;
    }
}
