package algorithm;

import java.util.Scanner;

/**
 * 0-1背包问题，动态规划
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0
 * Example:
 * Input:
 * 2
 * 3
 * 4
 * 1 2 3
 * 4 5 1
 * 3
 * 3
 * 1 2 3
 * 4 5 6
 * Output:
 * 3
 * 0
 * @author
 * 动态规划数组：dp[n+1][w+1].
 * dp[i][j]: 用前i个物品，总重量为j时，所能达到的最大value。
 * 状态转移方程：dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
 * 即取到第i个物品时，有两种选择，一种是不要第i件物品，则dp[i-1][j]；一种是要第i件物品，于是前面所能用的重量就为j-wt[i-1],因此总价值为 dp[i-1][j-wt[i-1]] + val[i-1]. 然后取两者之间最大的即可。
 */
public class Knapsack {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int w = scanner.nextInt();
            int[] val = new int[n];
            for (int i = 0; i < n; i++) {
                val[i] = scanner.nextInt();
            }
            int[] wt = new int[n];
            for (int i = 0; i < n; i++) {
                wt[i] = scanner.nextInt();
            }
            //动态规划数组
            int[][] dp = new int[n+1][w+1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= w; j++) {
                    // 初始化的情况。i=0或者j=0时，都不能取任何物品，价值为0
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    }
                    // 此时由于总重量限制，无法取第i件物品，因此只能是dp[i-1][j]
                    else if (wt[i-1] > j) {
                        dp[i][j] = dp[i-1][j];
                    }
                    // 此时分两种情况：取第i件或者不取第i件；取两者更大的即可。
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                    }
                }
            }
        }
    }
}
