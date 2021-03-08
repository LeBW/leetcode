/**
 * 1411. Number Of Ways to Paint N * 3 Grid
 * 数学题，将每一行的颜色分为两种：ABA 和 ABC。然后找递推公式
 * @author LBW
 */
public class NumberOfWaysToPaint {
    public int numOfWays(int n) {
        long[][] dp = new long[n + 1][2]; // 0 代表 ABA 型，1 代表 ABC 型
        dp[1][0] = 6;
        dp[1][1] = 6;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] * 3 + dp[i-1][1] * 2) % (1000000007);
            dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1] * 2) % (1000000007);
        }
        return (int)((dp[n][0] + dp[n][1]) % 1000000007);
    }
}
