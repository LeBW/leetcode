import java.util.*;

/**
 * 49. Group Anagrams 字母异位词分组
 * 哈希
 * @author LBW
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(str);
            map.put(key, l);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            // 这里不能用 cs.toString() ，否则 key 会无效！
            String key = String.valueOf(cs);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(key, l);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> list = groupAnagrams.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(list);
    }
}
