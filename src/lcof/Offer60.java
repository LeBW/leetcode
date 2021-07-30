package lcof;

/**
 * Offer 60. n 个骰子的点数
 * 动态规划。初始 dp 为 1 个骰子的点数和的概率分布。
 * 每次循环中，多考虑一个骰子，那么这个骰子的各个点数和都是从前一个骰子中而来。
 * 例如，对于点数 n，其只可能来自于前一个情况中的 n-1, n-2, n-3, n-4, n-5, n-6。
 * 用这种思想，dp[n] 就由 dp[n - 1] 推导而来。
 * 另外，为了避免二维dp带来的损耗，由于 dp[n] 只由 dp[n-1]而来，我们可以用两个数组交替进行
 * @author LBW
 */
public class Offer60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        for (int i = 0; i < 6; i++) {
            dp[i] = 1.0 / 6;
        }
        for (int k = 2; k <= n; k++) {
            double[] tmp = new double[5 * k + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < 6;j ++) {
                    tmp[i + j] += dp[i] / 6;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
