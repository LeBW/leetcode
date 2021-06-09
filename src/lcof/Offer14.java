package lcof;

/**
 * Offer14. 剪绳子
 * 动态规划。时间复杂度 O(n^2)
 * @author LBW
 */
public class Offer14 {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Offer14 offer14 = new Offer14();
        System.out.println(offer14.cuttingRope(3));
    }
}
