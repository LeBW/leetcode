import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * 前缀和 + 哈希。时间复杂度 O（n）
 * @author LBW
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        preSum[0] = 0;
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (map.containsKey(preSum[i] - k)) {
                res += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return res;
    }
}
