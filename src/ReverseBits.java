/**
 * 190. Reverse Bits
 * 位运算. 对于原始数字n ,从低位到高位,逐步抽出来,然后倒序的加入到 res 数字中
 * @author LBW
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res = res | ((n & 1) << (31 - i));  // 通过 或 操作,将位插入 res 中
            n = n >>> 1;  // 因为 Java 中没有 无符号整数,所以这里使用 逻辑位移.
        }
        return res;
    }
}
