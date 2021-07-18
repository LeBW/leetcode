package lcof;

/**
 * Offer 49. 丑数
 * 一个很巧妙的动态规划题目
 * 这里的关键是要理解：每个丑数都是由前面的丑数 * 2 或 * 3 或 * 5 得到的。
 * 因此我们用三个指针p2, p3, p5来指向下一个应该乘2，3，5的索引位置
 * @author LBW
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];   // dp[i] 代表 第 n 个丑数
        dp[1] = 1;  // 第一个丑数为 1.
        int p2 = 1, p3 = 1, p5 = 1; // p2, p3, p5 代表下一个丑数出现在 dp[p2] * 2, dp[p3] * 3, dp[p5] * 5 中
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2 += 1;
            }
            if (dp[i] == dp[p3] * 3) {   // 这里都不能使用 else，因为同一个数可能由多个算式得到，这几个全部都应该跳过
                p3 += 1;
            }
            if (dp[i] == dp[p5] * 5) {
                p5 += 1;
            }
        }
        return dp[n];
    }
}
