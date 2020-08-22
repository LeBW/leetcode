/**
 * 剑指 Offer 42. 连续子数组的最大和  LCOF
 * 基本的动态规划。
 * dp[i]: 以i结尾的子数组的最大和
 * @author LBW
 */
public class ContinuousSubarrayMaxSum {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i-1];
            }
            else {
                dp[i] = nums[i-1];
            }
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}
