/**
 * 461. Hamming Distance
 * 汉明距离，位操作
 * @author LBW
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int res = 0;
        while (t != 0) {
            res += t & 1;
            t = t >>> 1;
        }
        return res;
    }
}
