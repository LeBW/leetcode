package lcof;

/**
 * Offer 16. 数值的整数次方
 * @author LBW
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) {
            return 1.0;
        }
        long l = n; // 因为 int 在取反时可能会溢出，所以先转换为 long
        if (l < 0) {
            l = -l;
            x = 1 / x;
        }
        // 快速幂：将 l 看作二进制数，不断相乘
        double res = 1;
        while (l > 0) {
            if (l % 2 == 1) {// 说明 l 的末位是 1 {
                res *= x;
            }
            x *= x;
            l = l / 2;
        }
        return res;
    }
}
