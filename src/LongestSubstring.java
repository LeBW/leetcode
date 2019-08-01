import java.util.HashMap;
import java.util.HashSet;

/**
 * Longest substring without repeating characters.
 * <p>Given <tt>"abcabcbb"</tt>, the answer is  <tt>"abc"</tt>, which the length is 3.</p>
 * <p>Given <tt>"bbbbb"</tt>, the answer is "b", with the length of 1.</p>
 * 滑动窗口法。
 * 1. HashMap. 用map记录每个字符最后出现的index。j作为遍历变量，i随着j的变化而变化。当s[j]存在于map时，将i增加到最后遇到j的下一位，并且清空中间的map item。
 * 2. HashSet.
 * @author LBW
 */
public class LongestSubstring {
    public int lengthOfLongestSubString(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            //如果s[j]已经被遇到过的话，将i增加到s[j]上次被遇到时的下一位，并清空中间的map item
            if (map.containsKey(s.charAt(j))) {
                int i1 = map.get(s.charAt(j)) + 1;
                for (; i < i1; i++)
                    map.remove(s.charAt(i));
            }
            //s[j]没有遇到过时，直接将其加入map，并更新ans
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
    public int lengthOfLongestSubStringTwo(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int i = 0, j = 0, ans = 1;
        HashSet<Character> set = new HashSet<>();
        while (i < s.length()) {
            // 滑动窗口中，一直是通过j来增加set！！(如果使用i的话，可能出现i比j大的情况）
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            if (j - i > ans) {
                ans = j - i;
            }
            set.remove(s.charAt(i++));
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int result = longestSubstring.lengthOfLongestSubString("au");
        System.out.println(longestSubstring.lengthOfLongestSubStringTwo("sf"));
        System.out.println(result);
    }
}
