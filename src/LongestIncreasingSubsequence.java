import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * 方法一：动态规划，时间复杂度：O(n^2)
 * 方法二：贪心+二分查找，时间复杂度：O(nlogn)
 * @author LBW
 */
public class LongestIncreasingSubsequence {
    /**
     * 动态规划. 时间复杂度 O(n^2).
     * dp是动态规划数组
     * dp[i]:  以 nums[i] 结尾的最长子序列长度
     * 状态转移方程：dp[i] = Max(dp[j] + 1) subject. 0 <= j < i && nums[i] > nums[j]
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 贪心 + 二分查找。  时间复杂度：O(nlogn)
     * tail[i]表示: 长度为 i+1 的最长子序列中最后一个数
     * end 表示：当前最长子序列的长度的尾巴
     * 初始化时：tail[0] = nums[0], end = 0.
     * 然后用一次遍历，更新 tail 和 end.
     * 最后返回 end + 1.
     */
    public int lengthOfLISTwo(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] tail = new int[nums.length];
        int end = 0;
        tail[end] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[end]) {
                end = end + 1;
                tail[end] = nums[i];
            }
            else {
                // 找出tail数组中比nums[i]大的最小值，替换成nums[i]
                int j = 0, k = end;
                while (j < k) {
                    int mid = (j + k) / 2;
                    if (tail[mid] < nums[i]) {
                        j = mid + 1;
                    }
                    else {
                        k = mid;
                    }
                }
                tail[j] = nums[i];
            }
        }
        return end + 1;
    }



    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
