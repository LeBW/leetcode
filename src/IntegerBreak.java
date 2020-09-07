/**
 * 343. Integer Break 整数拆分
 * 动态规划。注意这里有两层循环，故时间复杂度为O(n^2).
 * @author LBW
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j, dp[i]) * (i-j));
        }
        return dp[n];
    }
}
