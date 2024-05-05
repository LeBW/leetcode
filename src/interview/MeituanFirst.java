package interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author LBW
 */
public class MeituanFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] count = new int[n + 1];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int cur = scanner.nextInt();
                if (cur < 1 || cur > n) {
                    flag = false;
                    break;   // 草，这里不能 break，因为会影响下一轮的输入
                }
                if (count[cur] > 0) {
                    flag = false;
                    break;   // 草，这里也不能 break，因为会影响下一轮的输入
                }
                count[cur] += 1;
            }
            System.out.println(flag ? "Yes" : "No");
        }
    }
}
