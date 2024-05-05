package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LBW
 */
public class MeituanFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[][] peopleDis = new int[n + 1][n + 1];
        int[][] carDis = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            carDis[x][y] = scanner.nextInt();
            carDis[y][x] = carDis[x][y];
            peopleDis[x][y] = scanner.nextInt();
            peopleDis[y][x] = peopleDis[x][y];
        }
        int[] wait = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wait[i] = scanner.nextInt();
        }
        if (start == end) {
            System.out.println(0);
            return;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i == start) {
                if (carDis[start][end] > 0) {
                    res = Math.min(res, wait[start] + carDis[start][end]);
                }
                continue;
            }
            if (peopleDis[start][i] > 0 && carDis[i][end] > 0) {
                int t = Math.max(peopleDis[start][i], wait[i]);
                t += carDis[i][end];
                res = Math.min(res, t);
            }
        }
        System.out.println(res);

    }
}
