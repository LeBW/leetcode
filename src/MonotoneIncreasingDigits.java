/**
 * 738. Monotone Increasing Digits
 * 贪心
 * @author LBW
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] digits = Integer.toString(N).toCharArray();
        int i;
        // 找到第一个 digits[i] > digits[i + 1] 的地方
        for (i = 0; i < digits.length - 1 && digits[i] <= digits[i + 1]; i++);
        // 如果没找到，说明数字本身就是递增的
        if (i == digits.length - 1)
            return N;
        // 把i后面的全部改成9
        for (int j = i + 1; j < digits.length; j++)
            digits[j] = '9';
        // 如果i与i-1相等，那么不能减i，继续往前找
        while (i > 0 && digits[i] == digits[i-1]) {
            digits[i] = '9';
            i--;
        }
        // 找到后，将i减1，此时后面全部是9
        digits[i] -= 1;
        return Integer.parseInt(String.valueOf(digits));
    }

}
