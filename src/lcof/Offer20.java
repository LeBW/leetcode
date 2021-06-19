package lcof;

/**
 * Offer20. 表示数值的字符串
 * 边界条件，各种细节非常多
 * @author LBW
 */
public class Offer20 {
    public boolean isNumber(String s) {
        int n = s.length();
        int start = 0;
        while (start < n && s.charAt(start) == ' ') {
            start += 1;
        }
        if (start == n)  // 全是空格，直接返回false
            return false;
        int end = n;
        while (s.charAt(end - 1) == ' ') {
            end -= 1;
        }
        int indexOfE = start;
        while (indexOfE < n && !(s.charAt(indexOfE) == 'e' || s.charAt(indexOfE) == 'E')) {
            indexOfE += 1;
        }
        if (indexOfE < n) { // 说明找到了 e/E
            if (indexOfE == n - 1) { // 说明 e/E 后面 没有了
                return false;
            }
            return (isInteger(s, start, indexOfE) || isDecimal(s, start, indexOfE)) && isInteger(s, indexOfE + 1, end);
        }
        // else
        return isInteger(s, start, end) || isDecimal(s, start, end);
    }

    private boolean isInteger(String s, int start, int end) {
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start += 1;
        }
        if (start >= end) {
            return false;
        }
        for (int i = start; i < end; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecimal(String s, int start, int end) {
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start += 1;
        }
        if (start >= end) {
            return false;
        }
        int countOfDot = 0;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == '.') {
                countOfDot += 1;
                if (countOfDot > 1)
                    return false;
            }
            else if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Offer20 offer20 = new Offer20();
        offer20.isNumber("0e");
    }
}
