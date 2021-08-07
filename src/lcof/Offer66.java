package lcof;

/**
 * Offer 66. 构建乘积数组
 * 本质就是利用两个 dp 数组，分别存储从左到右和从右到左的积。
 * 然后就可以在 O（n）时间内算出 b 了
 * @author LBW
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) {
            return new int[0];
        }
        if (n == 1) {
            return new int[]{0};
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        for (int i = 1; i < n; i++) {
            left[i] = left [i - 1] * a[i];
        }
        right[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i];
        }
        int[] b = new int[n];
        b[0] = right[1];
        b[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            b[i] = left[i - 1] * right[i + 1];
        }
        return b;
    }
}
