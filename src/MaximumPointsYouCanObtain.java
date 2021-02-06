/**
 * 1423. Maximum Points You can Obtain from Cards
 * 固定的滑动窗口
 * @author LBW
 */
public class MaximumPointsYouCanObtain {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int len = n - k;
        int l = 0, r = l + len - 1;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += cardPoints[i];
        }
        int min = sum;
        l++;
        r++;
        while (r < n) {
            sum = sum - cardPoints[l-1] + cardPoints[r];
            if (sum < min)
                min = sum;
            l++;
            r++;
        }
        int all = 0;
        for (int i = 0; i < n; i++)
            all += cardPoints[i];
        return all - min;
    }
}
