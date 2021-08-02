package lcof;

/**
 * Offer 64. 求 1+2+...+n
 * 短路效应
 * @author LBW
 */
public class Offer64 {
    private int res;
    public int sumNums(int n) {
        boolean b = (n > 1 && sumNums(n - 1) > 0);
        res += n;
        return res;
    }
}
