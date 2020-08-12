/**
 * 213. House Robber II
 * 打家劫舍II。
 * 动态规划。有环。
 * 解题思路：
 * 这个题目中，有环。此时应该将环“拆开”，也就是分两种情况
 * 1. 使用nums[0], 不使用 nums[end].
 * 2. 使用nums[end],不适用nums[0].
 * 然后用正常的打家劫舍问题求解以上两个子问题，然后求最大值即可。
 * @author LBW
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        return Math.max(maxMoney(nums, 0, len-2), maxMoney(nums, 1, len-1));
    }

    private int maxMoney(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1+start]);
        }
        return dp[nums.length-1];
    }
}
