import java.util.HashMap;
import java.util.HashSet;

/**
 * Longest substring without repeating characters.
 * <p>Given <tt>"abcabcbb"</tt>, the answer is  <tt>"abc"</tt>, which the length is 3.</p>
 * <p>Given <tt>"bbbbb"</tt>, the answer is "b", with the length of 1.</p>
 * 滑动窗口解决。
 * 1. HashMap. 2. HashSet.
 * @author LBW
 */
public class LongestSubstring {
    public int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int length = s.length();
        // sliding window: [i, j)
        int i = 0, j = 1, max = 1;
        // record char:index in sliding window.
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        while (j < length) {
            char c = s.charAt(j);
            //if c repeats, update max and map.
            if (map.containsKey(c)) {
                //update max
                max = Math.max(max, j - i);
                //remove from i to index. update i;
                int index = map.get(c);
                for (; i <= index; i++) {
                    map.remove(s.charAt(i));
                }
            }
            map.put(c, j);
            j++;
        }
        //update the last time
        max = Math.max(max, j-i);
        return max;
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
