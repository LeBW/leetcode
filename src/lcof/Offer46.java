package lcof;

/**
 * Offer 46. 把数字翻译成字符串
 * 动态规划
 * @author LBW
 */
public class Offer46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            int t = Integer.parseInt(str.substring(i - 2, i));
            if (t >= 10 && t <= 25) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
