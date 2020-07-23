/**
 * 306. Additive Number
 * @author LBW
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isAdditive(num, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean isAdditive(String num, int i, int j) {
        int cur = j + 1;  // current index
        if (cur >= num.length())
            return false;
        long num1 = getNumber(num, 0, i);
        long num2 = getNumber(num, i + 1, j);
        if (num1 == -1 || num2 == -1)
            return false;
        long sum = num1 + num2;
        while (cur < num.length()) {
            if (num.substring(cur).startsWith(Long.toString(sum))) {
                num1 = num2;
                num2 = sum;
                cur += Long.toString(sum).length();
                sum = num1 + num2;
            }
            else {
                return false;
            }
        }
        return true;
    }

    // return -1 when starts with '0'
    private long getNumber(String num, int l, int r) {
        if (num.charAt(l) == '0' && r > l)
            return -1;
        int i = l;
        long sum = 0;
        while (i <= r) {
            sum = sum * 10 + num.charAt(i) - '0';
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        AdditiveNumber additiveNumber= new AdditiveNumber();
        System.out.println(additiveNumber.isAdditiveNumber("111122335588143"));
    }
}
