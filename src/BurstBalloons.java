/**
 * 312. Burst Balloons.
 * @author LBW
 * 动态规划。
 * 巧妙的地方：在定义dp数组的时候，使用了开区间的概念，方便对子问题进行划分
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        //create a balloon array.
        int[] balloons = new int[nums.length+2];
        balloons[0] = balloons[balloons.length-1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            balloons[i] = nums[i-1];
        }
        // create dp array
        int[][] dp = new int[balloons.length][balloons.length];
        // init base case
        for (int i = 0; i < balloons.length - 1; i++) {
            dp[i][i+1] = 0;
        }
        // fill the array
        for (int j = 2; j < balloons.length; j++) {
            for (int i = j - 2; i >= 0; i--) {
                // determine the dp[i][j]
                dp[i][j] = 0;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + balloons[i] * balloons[k] * balloons[j]);
                }
            }
        }
        return dp[0][balloons.length-1];
    }
}
