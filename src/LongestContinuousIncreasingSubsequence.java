/**
 * 674. Longest Continuous Increasing Subsequence
 * @author LBW
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int ans = 1, cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                cur += 1;
                if (cur > ans)
                    ans = cur;
            }
            else {
                cur = 1;
            }
        }
        return ans;
    }
}
