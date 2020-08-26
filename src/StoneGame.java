/**
 * 877. Stone Game
 * @author LBW
 * 博弈DP问题。
 */
public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        Pair[][] dp = new Pair[len][len];
        // init
        for (int i = 0; i < len; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        // fill the dp array
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                if (left >= right) { // 先手选择左边
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                }
                else {  //先手选择右边
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }
        return dp[0][len-1].fir > dp[0][len-1].sec;
    }

    class Pair {
        int fir;
        int sec;
        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}
