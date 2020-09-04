/**
 * 978. Longest Turbulent Subarray
 * 动态规划。
 * dp[i]: 以i结尾的最长的湍流子数组
 * @author LBW
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2)
            return A.length;
        int[] dp = new int[A.length + 1];
        //init
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = A[1] == A[0] ? 1 : 2;
        int res = dp[2];
        // fill the dp array
        for (int i = 3; i <= A.length; i++) {
            if ((A[i-1] - A[i-2] > 0 && A[i-2] - A[i-3] < 0) || (A[i-1] - A[i-2] < 0 && A[i-2] - A[i-3] > 0)) {
                dp[i] = dp[i-1] + 1;
                if (dp[i] > res)
                    res = dp[i];
            }
            else if (A[i-1] == A[i-2]){
                dp[i] = 1;
            }
            else
                dp[i] = 2;
        }
        return res;
    }
}
