import java.util.*;

/**
 * <a href=https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/>
 * Click to see online description
 * </a>
 * <br>
 * @author LBW
 */
public class SubstringWithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> results = new ArrayList<>();
        if (s.isEmpty() || words.length == 0)
            return results;

        HashMap<String, Integer> map = new HashMap<>();
        int wordLen = words[0].length();
        int len = words.length * wordLen;

        //initiate the map.
        for (String word: words) {
            if (!map.containsKey(word))
                map.put(word, 1);
            else
                map.put(word, map.get(word)+1);
        }

        //find the substring.
        for (int i = 0; i < s.length() - len + 1; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                String temp = s.substring(i + j * wordLen, i + (j+1)*wordLen);
                if (tempMap.containsKey(temp)) {
                    tempMap.put(temp, tempMap.get(temp)-1);
                }
                else {
                    break;
                }
            }
            boolean flag = true;
            for (Map.Entry<String, Integer> set: tempMap.entrySet()) {
                if (set.getValue() != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                results.add(i);
        }
        return results;
    }

    public static void main(String[] args) {
        SubstringWithConcatenation concatenation = new SubstringWithConcatenation();
        System.out.println(concatenation.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
