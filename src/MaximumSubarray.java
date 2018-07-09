/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * @author LBW
 */
public class MaximumSubarray {
    public int maxSubarray(int[] nums) {
        int len = nums.length;

        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < len; i++) {
            sum = Math.max(sum + nums[i], nums[i]);

            if (sum > max)
                max = sum;
        }
        return max;
    }
}
