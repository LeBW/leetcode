/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * @author LBW
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int t = x % 10;
            x = x/10;
            //check whether result is going to overflow.
            if (t > 0 && result > (Integer.MAX_VALUE - t) / 10 )
                return 0;
            if (t < 0 && result < (Integer.MIN_VALUE - t) / 10)
                return 0;
            result = result * 10 + t;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
    }
}
