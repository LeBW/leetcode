/**
 * 416. Partition Equal Subset Sum
 * 0-1背包问题的变种：集合中是否存在子集subset，使得子集和等于 sum/2.
 * @author LBW
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        //dp数组。 dp[i][j]: 前i个元素中是否存在子集能够组成和为j
        boolean[][] dp = new boolean[n+1][target+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else //分两种情况：不使用元素nums[i-1] 或 使用元素nums[i-1].
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][target];
    }
}
