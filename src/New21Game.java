/**
 * 837. New 21 Game
 * 新21点游戏。
 * 动态规划：dp[i]:表示从i开始，获胜的概率。从后往前进行计算，dp[0]即为结果。
 * 注意：简易的状态转移方程会超时，可以通过数学公式消除重复计算。
 * 另外对于K-1，也要单独处理.
 * @author LBW
 */
public class New21Game {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        int i = K + W - 1;
        while (i > N) {
            dp[i] = 0;
            i -= 1;
        }
        while (i >= K) {
            dp[i] = 1;
            i -= 1;
        }
        // i = K - 1 时，不能通过新的状态转移方程
        if (i >= 0) {
            dp[i] = 0;
            for (int k = 1; k <= W; k++) {
                dp[i] += dp[i + k];
            }
            dp[i] = dp[i] / W;
        }
        // 然后，用新的状态转移方程
        i -= 1;
        while (i >= 0) {
            dp[i] = dp[i+1] - (dp[i+W+1] - dp[i+1]) / W;
            i -= 1;
        }
        return dp[0];
    }
}
