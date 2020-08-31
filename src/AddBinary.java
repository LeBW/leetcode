/**
 * 67. Add Binary
 * @author LBW
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int lenA = a.length(), lenB = b.length();
        int i = lenA - 1, j = lenB - 1, carry = 0;
        while (i >= 0 && j >= 0) {
            int tmp = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry;
            carry = tmp / 2;
            res.insert(0, tmp % 2);
        }
        while (i >= 0) {
            int tmp = a.charAt(i--) - '0' + carry;
            carry = tmp / 2;
            res.insert(0, tmp % 2);
        }
        while (j >= 0) {
            int tmp = b.charAt(j--) - '0' + carry;
            carry = tmp / 2;
            res.insert(0, tmp % 2);
        }
        if (carry == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }
}
