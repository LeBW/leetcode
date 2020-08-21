import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * 连续的子数组和
 * @author LBW
 */
public class ContinuousSubarraySum {
    /**
     * 方法一：两次循环。时间复杂度O(n^2).
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2)
            return false;
        for (int i = 1; i < nums.length; i++) {
            // from i to 0
            int cur = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                cur += nums[j];
                if ((k == 0 && cur == 0) || (k != 0 && cur % k == 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 方法二：HashMap存放已有的和 % k.
     * 当遇到冲突时，说明中间有一个子数组的和为k的倍数
     * 时间复杂度O(n).
     */
    public boolean checkSubarraySumTwo(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 0);
        for (int i = 1; i <= nums.length; i++) {
            if (k == 0)
                sum = sum + nums[i-1];
            else
                sum = (sum + nums[i-1]) % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            }
            else
                map.put(sum, i);
        }
        return false;
    }
}
