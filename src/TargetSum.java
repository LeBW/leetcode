/**
 * 494. Target Sum
 * @author LBW
 */
public class TargetSum {
    private int count;

    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        findTargetSumWays(nums, S, 0);
        return count;
    }
    /*
    方法一：枚举（回溯）。时间复杂度 O(2^n).
     */
    private void findTargetSumWays(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            if (target == 0) {
                count += 1;
            }
            return;
        }
        findTargetSumWays(nums, target + nums[idx], idx + 1);
        findTargetSumWays(nums, target - nums[idx], idx + 1);
    }

    /*
    方法二：动态规划. 时间复杂度O(n*sum). 这里sum是 nums数组中所有数字的和。
     */
    private int findTargetSumWaysTwo(int[] nums, int S) {
        int sum = 0;
        for (int num: nums)
            sum += num;
        // 如果需要的和S 比 sum 还大，说明不可能达成。
        if (Math.abs(S) > sum)
            return 0;
        // 动态规划数组dp
        // dp[i][j]: 用前i个数 组成 j 的 可行数。
        int[][] dp = new int[nums.length + 1][sum+1];
        dp[0][0] = 1;  // 用0个数，组成和为0，有一种方案；组成其他和（>0),均为0.
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {  // 这里第二层循环一定要遍历到 sum，而不是 S。因为这里数字可以取负，所以即使中间的结果大于S，最后也可能组成S
                // 状态转移方程。
                // 值得注意的是：组成 S 和 组成 -S 的个数是一样的（只需将所有符号取反即可）。
                dp[i][j] = dp[i - 1][Math.abs(j - nums[i - 1])] + (j + nums[i - 1] <= sum ? dp[i - 1][j + nums[i - 1]] : 0);
            }
        }

        return dp[nums.length][Math.abs(S)];
    }
}
