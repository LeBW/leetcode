/**
 * @author LBW
 */
public class MyAtoi {
    public int myAtoi(String str) {
        int len = str.length();
        //judge whether str is empty.
        if (len <= 0)
            return 0;

        StringBuilder stringBuilder = new StringBuilder(str);
        boolean negative = false;  //whether the integer is positive or negative.
        int limit = -Integer.MAX_VALUE;
        int result = 0;
        int i = 0;

        //remove whitespace characters.
        while (stringBuilder.length() > 0 &&  stringBuilder.charAt(0) == ' ')
            stringBuilder.deleteCharAt(0);
        len = stringBuilder.length();
        if (len <= 0) //judge whether str is all whitespace
            return 0;

        //judge plus-minus sign.
        char c = stringBuilder.charAt(0);
        if (c < '0') {
            if (c == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
            }
            else if (c != '+')
                return 0;
            if (len == 1)  //Cannot have lone "+" or "-".
                return 0;
            i++;
        }
        //accumulate the result
        for(; i < len; i++) {
            c = stringBuilder.charAt(i);
            if (Character.digit(c, 10) >= 0) {
                //judge whether the value is going to overflow
                if (result < (limit + Character.digit(c, 10)) / 10) {
                    return negative ? limit : -limit;
                }
                result = result * 10 - Character.digit(c, 10);
            }
            else
                break;
        }
        result = negative ? result : -result;

        return result;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("-9999999999"));
    }
}
