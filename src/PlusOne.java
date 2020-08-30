/**
 * 66. Plus One
 * 数组
 * @author LBW
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int cur = digits.length - 1;
        digits[cur] += 1;
        while (cur >= 1 && digits[cur] == 10) {
            digits[cur--] = 0;
            digits[cur] += 1;
        }
        if (cur == 0 && digits[cur] == 10) { // 产生进位，原来的长度不够，所以另起新的数组
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            res[1] = 0;
            System.arraycopy(digits, 1, res, 2, res.length - 2);
            return res;
        }
        else
            return digits;
    }
}
