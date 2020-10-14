import java.util.ArrayList;
import java.util.List;

/**
 * 1002. Find Common Characters
 * 哈希
 * @author LBW
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int len = A.length;
        int[] minFreq = new int[26];
        // init minFreq
        for (char c: A[0].toCharArray()) {
            minFreq[c - 'a'] += 1;
        }
        // traverse A, and update minFreq
        for (int i = 1; i < len; i++) {
            int[] freq = new int[26];
            for (char c: A[i].toCharArray()) {
                freq[c - 'a'] += 1;
            }
            // update minFreq
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], freq[j]);
            }
        }
        // get the result.
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int n = minFreq[i];
            for (int j = 0; j < n; j++) {
                res.add(String.valueOf((char)('a' + i)));
            }
        }
        return res;
    }
}
