import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * 两个哈希表
 * @author LBW
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] patterns = pattern.toCharArray();
        String[] words = s.split(" ");
        if (patterns.length != words.length)
            return false;
        int n = patterns.length;
        String[] map = new String[26];
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map[patterns[i] - 'a'] == null && !map2.containsKey(words[i])) {
                map[patterns[i] - 'a'] = words[i];
                map2.put(words[i], patterns[i]);
            }
            else if (map[patterns[i] - 'a'] != null && !map[patterns[i] - 'a'].equals(words[i])){
                return false;
            }
            else if (map2.containsKey(words[i]) && map2.get(words[i]) != patterns[i]) {
                return false;
            }
        }
        return true;
    }
}
