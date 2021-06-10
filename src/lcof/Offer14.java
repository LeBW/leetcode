package lcof;

import java.math.BigInteger;

/**
 * Offer14. 剪绳子
 * 动态规划。时间复杂度 O(n^2)\
 * 注意，这里利用了 BigInteger，因为 long 也不够。。
 * @author LBW
 */
public class Offer14 {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        BigInteger[] dp = new BigInteger[n+1];
        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(2);
        dp[3] = BigInteger.valueOf(3);
        dp[4] = BigInteger.valueOf(4);
        for (int i = 5; i <= n; i++) {
            dp[i] = BigInteger.valueOf(i);
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        Offer14 offer14 = new Offer14();
        System.out.println(offer14.cuttingRope(120));
    }
}
