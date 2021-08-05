package lcof;

/**
 * Offer 65. 不用加减乘除做加法
 * 利用 异或 和 与 进行位运算。
 * 总体思路：对于 a 和 b，与得到的结果左移一位就是进位（ 设为 c），异或的结果就是不算进位的和（设为 n），那么 a + b 就转化为了 n + c.
 * 利用这种转换循环，直至 c = 0，那么就得到了答案。
 * @author LBW
 */
public class Offer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;  // c 存储 a 和 b 加法后的进位
            a = (a ^ b);   // 这里的 a 其实就是 a 和 b 加法无进位的和
            b = c;  // b 存储进位。如果进位不等于0的话，就需要继续循环做加法
        }
        return a;
    }
}
