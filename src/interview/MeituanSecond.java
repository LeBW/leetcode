package interview;

import java.util.Scanner;

/**
 * @author LBW
 */
public class MeituanSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            int n = s.length();
            int i = (n - 1) / 2;
            int res = 0;
            for (; i < n; i++) {
                if (isOk(s, i)) {
                    res = 2 * i + 1 - n;
                    break;
                }
                if (isOk(s, i, i + 1)) {
                    res = 2 * i + 2 - n;
                    break;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean isOk(String s, int i1, int i2) {
        int left = i1, right = i2;
        while (right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return right == s.length();
    }

    private static boolean isOk(String s, int i) {
        if (i < s.length() / 2) {
            return false;
        }
        int left = i - 1, right = i + 1;
        while (right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return right == s.length();
    }
}
