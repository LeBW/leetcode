package lcof;

/**
 * Offer 43. 1～n 整数中 1 出现的次数
 * 数学，找规律
 * @author LBW
 */
public class Offer43 {
    public int countDigitOne(int n) {
        int digit = 1, cur = n % 10;
        int low = 0, high = n / 10;
        int res = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            }
            else if (cur == 1) {
                res += high * digit + low + 1;
            }
            else {
                res += (high + 1) * digit;
            }
            // update digit, cur, low, high
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer43 offer43 = new Offer43();
        System.out.println(offer43.countDigitOne(12));
    }
}
