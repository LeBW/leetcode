/**
 * 191. Number Of 1 Bits
 * 这里利用 n & (n - 1) 的性质：会使 n 的最低位的 1 变为 0.
 * @author LBW
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }
}
