/**
 * 643. Maximum Average Subarray I
 * 滑动窗口
 * @author LBW
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0, end = k - 1;
        double curSum = 0;
        for (int i = start; i <= end; i++) {
            curSum += nums[i];
        }
        double res = curSum / k;
        start += 1;
        end += 1;
        while (end < nums.length) {
            curSum = curSum - nums[start-1] + nums[end];
            res = Math.max(res, curSum / k);
            start += 1;
            end += 1;
        }
        return res;
    }
}
