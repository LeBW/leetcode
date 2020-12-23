import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * 哈希
 * @author LBW
 */
public class FirstUniqueCharacter {
    /*
    Method 1: HashMap.  44ms
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        int i = 0;
        for (; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    /*
    Method 2: Array as map.  6ms
     */
    public int firstUniqCharTwo(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
