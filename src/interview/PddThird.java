package interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author LBW
 */
public class PddThird {
    private static boolean flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int a, b, c, q;
        while (T-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            q = scanner.nextInt();
            flag = false;
            Set<Integer> nums = new HashSet<>();
            dfs(nums, a, b, c, q);
            if (flag) {
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }

    private static void dfs(Set<Integer> nums, int a, int b, int c, int q) {
        int cur = a;
        while (cur <= q) {
            if (nums.add(cur)) {
                dfs(nums, cur, b, c, q);
            }
            if (cur == q) {
                flag = true;
                return;
            }
            cur += b;
        }
        cur = a;
        while (cur <= q) {
            if (nums.add(cur)) {
                dfs(nums, cur, b, c, q);
            }
            if (cur == q) {
                flag = true;
                return;
            }
            cur *= c;
        }
    }

}