package lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * Offer 48. 最长不含重复字符的子字符串
 * 滑动窗口，哈希表
 * @author LBW
 */
public class Offer48 {
    // 这是我自己的方法，用的是典型的滑动窗口，会一直维护一个没有重复元素的窗口[left, right]
    // map 中维护的是当前滑动窗口出现过的字符的位置。
    // 所以在更新时，可以无脑的 leftTarget = map.get(s.charAt(i))。
    // 缺点就是在更新 left 时，需要遍历型 remove map。
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                int leftTarget = map.get(s.charAt(i));
                while (left <= leftTarget) {  // 这里的处理是一直从左往右从 map 中进行 remove 操作，稍微有一点慢，其实有更好的办法
                    map.remove(s.charAt(left++));
                }
            }
            res = Math.max(res, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }

    // 这是答案的做法。
    // 这里的 map，维护的不是滑动窗口中出现的元素，而是前面出现的所有元素
    // 所以此时当遇到重复元素时，不能无脑 left = map.get(s.charAt(i)) + 1 了。
    // 只有当 map.get(s.charAt(i) + 1 > left 时才需要更新 left，这是因为有可能会遇到 pwwkew 这种情况，中间夹杂着非s[i]引起的重复子串，因此 left 要一直维护往右增加。
    public int lengthOfLongestSubstringTwo(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            res = Math.max(res, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}
