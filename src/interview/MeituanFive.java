package interview;

import java.util.Scanner;

/**
 * @author LBW
 */
public class MeituanFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), p = scanner.nextInt();
        String s = scanner.next();
        boolean[] isok = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            isok[i] = (s.charAt(i - 1) == 'o');
        }
        int[] forces = new int[p + 1];
        for (int i = 1; i <= p; i++) {
            forces[i] = scanner.nextInt();
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (!isok[i]) {
                continue;
            }
            for (int k = 1; k <= 5; k++) {
                if (i - k > 0 && isok[i - k]) {
                    dp[i] = Math.min(dp[i], dp[i - k] + forces[k]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
