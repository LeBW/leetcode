package interview;

import java.util.Scanner;

/**
 * @author LBW
 */
public class PddFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            lines[i][0] = scanner.nextInt();
            lines[i][1] = scanner.nextInt();
        }
        //Arrays.sort(lines, Comparator.comparingInt(Pair::getKey));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (contains(lines[i], lines[j])) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }

    private static boolean contains(int[] a, int[] b) {
        if (a[0] >= b[0] && a[1] <= b[1]) {
            return true;
        }
        return a[0] <= b[0] && a[1] >= b[1];
    }
}
