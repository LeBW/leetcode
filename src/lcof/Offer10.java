package lcof;

/**
 * Offer10. 斐波拉契数列
 * @author LBW
 */
public class Offer10 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int n1 = 0, n2 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = n2;
            n2 = (n1 + n2) % 1000000007;
            n1 = tmp;
        }
        return n2;

    }
}
