/**
 * 424. Longest Repeating Character Replacement
 * @author LBW
 * 滑动窗口。
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int len = s.length(), left = 0, right = 0;
        int[] count = new int[26]; // 存储字母出现的次数
        int maxCount = 0; //存储出现次数最多的字母的次数
        int result = 0;
        while (right < len) {
            char c = s.charAt(right);
            count[c - 'A'] += 1;
            maxCount = Math.max(maxCount, count[c -'A']);
            if (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A'] -= 1;
                left += 1;
                // 此时不用减小maxCount，因为不会影响最终结果。
            }
            else {
                result = Math.max(result, right - left + 1);
            }
            right += 1;
        }
        return result;
    }
}
