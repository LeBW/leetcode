/**
 * 338. Counting Bits
 * 动态规划 + 位运算
 * 设 res[i] 表示数字 i 的二进制表示中 1 的数目。
 * 如果 i 是奇数，那么 res[i] = res[i-1] + 1，因为它永远比它之前的那个偶数多末尾的 1.
 * 如果 i 是偶数，那么 res[i] = res[i / 2]，因为 i 只是比 i/2 多了末尾的0
 * @author LBW
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        // res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            }
            else {
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}
