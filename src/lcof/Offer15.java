package lcof;

/**
 * Offer15. 二进制中 1 的个数
 * 位运算
 * @author LBW
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }


}
