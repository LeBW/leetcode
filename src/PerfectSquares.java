import java.util.Arrays;

/**
 * 279. Perfect Squares
 * 动态规划
 * @author LBW
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (dp[i] == 1)
                continue;
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        return dp[n];
    }
}
