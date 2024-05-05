import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * 用到了哈希集，思路很难想到
 *
 * @author LBW
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 先用 set 存储所有数
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        // 循环计算每个数字开头的最长连续序列的长度，取最大值
        int max = 0;
        for (int num: set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int cur = num;
            while (set.contains(cur + 1)) {
                cur += 1;
            }
            max = Math.max(max, cur - num + 1);
        }
        return max;
    }

}
