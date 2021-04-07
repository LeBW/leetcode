package interview;

import java.util.*;
/**
 * @author LBW
 */
public class HuaweiThree {
    private static int result = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt(), c = scanner.nextInt(), t = scanner.nextInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        // find time
        dfs(matrix, r, c, t,0, 0, matrix[0][0]);
        System.out.println(result);
    }

    private static void dfs(int[][] matrix, int r, int c, int t, int i, int j, int cur) {
        if (cur > t) {
            return;
        }
        if (i == r - 1 && j == c - 1) {
            if (cur > result) {
                result = cur;
            }
            return;
        }
        if (i + 1 < r)
            dfs(matrix, r, c, t, i + 1, j, cur + matrix[i + 1][j]);
        if (j + 1 < c)
            dfs(matrix, r, c, t, i, j + 1, cur + matrix[i][j + 1]);
    }
}
