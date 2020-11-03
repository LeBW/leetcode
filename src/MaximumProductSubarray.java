/**
 * 152. Maximum Product Subarray
 * 动态规划。
 * dp[i][0]: 以i结尾的子数组的最小乘积。
 * dp[i][1]: 以i结尾的子数组的最大乘积。
 * 注意要二维，记录最小值和最小值，因为有负数，所以最小值和最大值之间可以互换。
 * @author LBW
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        int result = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(nums[i], Math.min(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]));
            dp[i][1] = Math.max(nums[i], Math.max(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]));
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}
