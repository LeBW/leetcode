/**
 * 43. Multiply Strings
 * @author LBW
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        for (char c: num2.toCharArray()) {
            // char c * num1
            StringBuilder tmp = multiply(c, num1);
            result = stringAdd(result.append('0'), tmp);
        }
        return result.toString();
    }

    private StringBuilder multiply(char c, String num) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int ci = c - '0';
        char[] arr = num.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = (arr[i] - '0') * ci + carry;
            carry = tmp / 10;
            builder.insert(0, tmp % 10);
        }
        if (carry > 0) {
            builder.insert(0, carry);
            carry = 0;
        }
        return builder;
    }

    private StringBuilder stringAdd(StringBuilder num1, StringBuilder num2) {
        int i1 = num1.length() - 1, i2 = num2.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();
        while (i1 >= 0 && i2 >= 0) {
            int tmp = num1.charAt(i1)-'0' + num2.charAt(i2)-'0' + carry;
            carry = tmp / 10;
            result.insert(0, tmp % 10);
            i1 -= 1;
            i2 -= 1;
        }
        while (i1 >= 0) {
            int tmp = num1.charAt(i1) - '0' + carry;
            carry = tmp / 10;
            result.insert(0, tmp % 10);
            i1 -= 1;
        }
        while (i2 >= 0) {
            int tmp = num2.charAt(i2) - '0' + carry;
            carry = tmp / 10;
            result.insert(0, tmp % 10);
            i2 -= 1;
        }
        if (carry == 1) {
            result.insert(0, carry);
            carry = 0;
        }
        return result;
    }
}
