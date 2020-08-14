import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 740. Delete and Earn
 * @author LBW
 */
public class DeleteAndEarn {
    /**
     * Method 1: 记忆化回溯。 超时
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Map<Set<Integer>, Integer> memo = new HashMap<>();
        int max = maxPoints(map, memo);
        return max;
    }

    private int maxPoints(Map<Integer, Integer> map, Map<Set<Integer>, Integer> memo) {
        Set<Integer> keySet = new HashSet<>(map.keySet());
        if (memo.containsKey(keySet)) {
            return memo.get(keySet);
        }
        int max = 0;
        Map<Integer, Integer> copied = new HashMap<>(map);
        for (Map.Entry<Integer, Integer> entry: copied.entrySet()) {
            Integer key = entry.getKey(), value = entry.getValue();
            Integer keyLeft = key - 1, valueLeft = map.get(keyLeft);
            Integer keyRight = key + 1, valueRight = map.get(keyRight);
            map.remove(entry.getKey());
            if (valueLeft != null)
                map.remove(keyLeft);
            if (valueRight != null)
                map.remove(keyRight);
            max = Math.max(max, key * value + maxPoints(map, memo));
            // recover
            map.put(key, value);
            if (valueLeft != null)
                map.put(keyLeft, valueLeft);
            if (valueRight != null)
                map.put(keyRight, valueRight);
        }
        memo.put(keySet, max);
        return max;
    }

    /**
     * Method 2: 动态规划（自底向上）
     * 将nums数组转化为values数组，其中
     * values[i]: i出现的次数*i.
     * 于是将问题转化为了 198.打家劫舍问题。利用动态规划即可求解。
     * @param nums
     * @return
     */
    public int deleteAndEarnTwo(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int max = nums[0], len = nums.length;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // create values array
        int[] values = new int[max+1];
        for (int num: nums) {
            values[num] += num;
        }
        // create dp array
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = values[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + values[i]);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{8,10,4,9,1,3,5,9,4,10}));
    }
}
