import java.util.Arrays;

/**
 * @author LBW
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K+1][n];
        Arrays.fill(dp[0], -1);
        // 到自己的价格为0
        dp[0][src] = 0;
        // 初始化能直达的目的地和价格
        for (int[] flight: flights) {
            if (flight[0] == src) {
                dp[0][flight[1]] = flight[2];
            }
        }
        // 状态转移，填充dp数组
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                // 求dp[i][j]
                dp[i][j] = Integer.MAX_VALUE;
                if (dp[i-1][j] >= 0)
                    dp[i][j] = dp[i-1][j];
                for (int[] flight: flights) {
                    if (flight[1] == j && dp[i-1][flight[0]] > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][flight[0]] + flight[2]);
                    }
                }
                if (dp[i][j] == Integer.MAX_VALUE)
                    dp[i][j] = -1;
            }
        }
        return dp[K][dst];
    }
}
