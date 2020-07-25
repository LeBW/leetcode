import java.util.*;

/**
 * 140. Word Break II
 * 记忆化回溯法
 * @author LBW
 */
public class WordBreakII {
    private Map<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet, 0);
    }

    private List<String> wordBreak(String s, Set<String> wordSet, int start) {
        if (map.containsKey(start))
            return map.get(start);
        List<String> result = new LinkedList<>();
        if (start == s.length())
            result.add("");
        for (int i = start + 1; i < s.length() + 1; i++) {
            if (wordSet.contains(s.substring(start, i))) {
                List<String> list = wordBreak(s, wordSet, i);
                for (String l: list) {
                    if (l.equals(""))
                        result.add(s.substring(start, i));
                    else
                        result.add(s.substring(start, i) + " " + l);
                }
            }
        }
        map.put(start, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        wordBreakII.wordBreak("catsanddog", wordDict);
    }
}
