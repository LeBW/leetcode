/**
 * 1052. Grumpy Bookstore Owner
 * 滑动窗口
 * @author LBW
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0, n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;
            }
        }
        int i = 0, j = i + X - 1;
        int cur = 0;
        for (int k = i; k < n && k <= j; k++) {
            cur += customers[k];
        }
        int max = cur;
        while (j < n) {
            i += 1;
            j += 1;
            if (j >= n)
                break;
            cur = cur - customers[i-1] + customers[j];
            max = Math.max(max, cur);
        }
        return res + max;

    }
}
