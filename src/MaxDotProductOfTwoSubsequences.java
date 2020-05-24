/**
 * 5419. Max Dot Product of Two Subsequences
 * 动态规划。初始化二维数组dp[][]，含义如下：
 * dp[i][j]: 意味着nums1[i]和nums2[j]为止的子序列的最大点积。为止意味着以谁结尾无所谓，关键是最大的。
 *
 * 所以状态转移方程为：
 * `dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i-1][j], dp[i-1][j-1] + nums1[i]*nums2[j], nums1[i]*nums2[j]`.
 * 其中要注意的是，要注意负数的情况。如果dp[i-1][j-1]<0 并且 nums1[i]*nums2[j]<0, 其实还是要选一个稍微偏大的负数，不能全舍掉，所以写法要像上面那样才行。
 * @author LBW
 */
public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        int max = 0;
        dp[0][0] = nums1[0] * nums2[0];
        for (int i = 1; i < nums1.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], nums1[i]*nums2[0]);
        }
        for (int j = 1; j < nums2.length; j++) {
            dp[0][j] = Math.max(dp[0][j-1], nums1[0]*nums2[j]);
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                dp[i][j] = dp[i-1][j-1] + Math.max(nums1[i] * nums2[j], 0);
                dp[i][j] = Math.max(dp[i][j], nums1[i] * nums2[j]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }
}
