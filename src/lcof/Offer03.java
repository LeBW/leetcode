package lcof;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 哈希
 * @author LBW
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dp[nums[i]]) {
                return nums[i];
            }
            dp[nums[i]] = true;
        }
        return -1;
    }
}
