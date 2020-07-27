/**
 * 50. Pow(x, n)
 * Binary Exponentiation. 二分法求幂
 * @author LBW
 */
public class PowXN {
    public double myPow(double x, int n) {
        if ((long) n < 0) {
            return 1 / myPowHelper(x, -(long) n);
        }
        else {
            return myPowHelper(x, n);
        }
    }

    private double myPowHelper(double x, long n) {
        if (n == 0)
            return 1;
        double tmp = myPowHelper(x, n / 2);
        if (n % 2 == 1) {
            return tmp * tmp * x;
        }
        else {
            return tmp * tmp;
        }
    }
}
