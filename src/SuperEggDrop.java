/**
 * 887. Super Egg Drop. 高楼扔鸡蛋
 * 动态规划 + 二分查找
 * @author LBW
 */
public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        // init
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }
        // fill the array.
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // compute dp[i][j]
                // 从 1~i 中 二分查找
                int left = 1, right = i;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2; // 要向上取整
                    if (dp[mid-1][j-1] > dp[i-mid][j]) {
                        // 严格大于时，排除
                        right = mid - 1;
                    }
                    else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[left-1][j-1], dp[i-left][j]) + 1;
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        System.out.println(superEggDrop.superEggDrop(1, 2));
    }
}
