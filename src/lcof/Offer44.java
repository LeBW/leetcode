package lcof;

/**
 * Offer 44. 数字序列中某一位的数字
 * 数学，找规律
 * @author LBW
 */
public class Offer44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;  // 这里的 count 必须用 long，因为最后一次循环时 count 可能会超出 int 范围
        while (n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        int idx = (n - 1) / digit, bias = (n - 1) % digit;
        long startNum = start + idx;
        return String.valueOf(startNum).charAt(bias) - '0';
    }
}
