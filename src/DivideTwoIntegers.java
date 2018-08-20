/**
 * <a href=https://leetcode-cn.com/problems/divide-two-integers/description/>
 * Click to see online description
 * </a>
 * <br>
 * @author LBW
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        if (ldividend < ldivisor || ldividend == 0)
            return 0;

        long lresult = divide(ldividend, ldivisor);
        int result = 0;
        if (lresult > Integer.MAX_VALUE) {
            result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        else
            result = (int)(sign*lresult);
        return result;

    }
    public long divide(long ldividend, long ldivisor) {
        long temp = 0, result = 0;

        for (int i = 31; i >= 0; i--) {
            if (temp + (ldivisor << i) <= ldividend) {
                temp += ldivisor << i;
                result += (long)1 << i;
                if (temp == ldividend)
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(0x80000000, -1));
    }
}
