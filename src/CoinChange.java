/**
 * 322. Coin Change
 * 动态规划
 * @author LBW
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 动态规划数组
        dp[0] = 0;  // 初始化。凑0时，需要0个硬币
        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            // 尝试每个硬币带来的解，取最小值
            for (int coin: coins) {
                // 硬币面值过大，或者字问题无解时，跳过
                if (i - coin < 0 || dp[i - coin] == -1)
                    continue;
                // 不断更新最小值
                minCount = Math.min(minCount, dp[i - coin] + 1);
            }
            dp[i] = (minCount == Integer.MAX_VALUE ? -1 : minCount);  // 无解时要返回-1.
        }
        return dp[amount];
    }
}
