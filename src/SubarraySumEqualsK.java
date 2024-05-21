import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * 前缀和 + 哈希。时间复杂度 O（n）
 * @author LBW
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // preSum[i] 记录数组从 0 ~ i 的和
        int[] preSum = new int[len + 1];
        // map 记录前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        preSum[0] = 0;
        map.put(0, 1);
        int result = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            // 此时需要寻找前面是否有 preSum[j] 使得 preSum[i] - preSum[j] = k
            if (map.containsKey(preSum[i] - k)) {
                result += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return result;
    }
}
