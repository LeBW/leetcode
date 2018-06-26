import java.util.HashMap;
/**
 * Longest substring without repeating characters.
 * <p>Given <tt>"abcabcbb"</tt>, the answer is  <tt>"abc"</tt>, which the length is 3.</p>
 * <p>Given <tt>"bbbbb"</tt>, the answer is "b", with the length of 1.</p>
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

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int result = longestSubstring.lengthOfLongestSubString("au");
        System.out.println(result);
    }
}
