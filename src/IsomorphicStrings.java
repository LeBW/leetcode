import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * 双哈希，一一对应
 * @author LBW
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if ((map1.containsKey(c1) && map1.get(c1) != c2) || (map2.containsKey(c2) && map2.get(c2) != c1)) {
                return false;
            }
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }
}
