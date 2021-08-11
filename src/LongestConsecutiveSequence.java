import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * @author LBW
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int res = 0;
        for (int num: nums) {
            if (set.contains(num - 1)) {  //  说明 num 不是序列中的第一个元素，可以跳过
                continue;
            }
            int curLength = 1;
            while (set.contains(num + 1)) {
                curLength += 1;
                num += 1;
            }
            res = Math.max(res, curLength);
        }
        return res;
    }
}
