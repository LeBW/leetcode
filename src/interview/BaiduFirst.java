package interview;

/**
 * 百度一面笔试题
 * 现在给一个对应关系，1 -> a, 2 -> b, ... , 26 -> z.
 * 然后给一个由数字组成的字符串，例如 "123"，求能够组成的字母组合有多少种？
 * 例如，对于 “123”，可以有 1 | 2 | 3,  12 | 3, 1 | 23 这三种组合
 * @author LBW
 */
public class BaiduFirst {
    public int reverse(String str) {
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            dp[i] = 0;
            if (str.charAt(i - 1) >= '1' && str.charAt(i - 1) <= '9') {
                dp[i] += dp[i - 1];
            }
            int t = Integer.parseInt(str.substring(i - 2, i));
            if (t <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        BaiduFirst baiduFirst = new BaiduFirst();
        System.out.println(baiduFirst.reverse("120"));
    }
}
