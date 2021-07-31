package interview;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LBW
 */
public class PddInterviewFirst {
    private static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int m = matrix.length, n = matrix[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        int i = 0, j = -1;
        for (int k = 0; k < m * n; k++) {
            while (shouldChange(i, j, m, n, idx, hasVisited)) {   // 一定要先转方向，再判断，这样可以避免最后一个元素访问完后进入死循环。
                idx = (idx + 1) % 4;
            }
            i += directions[idx][0];
            j += directions[idx][1];
            res.add(matrix[i][j]);
            hasVisited[i][j] = true;
        }
        System.out.println(res.toArray());
    }

    private static boolean shouldChange(int i, int j, int m, int n, int idx, boolean[][] hasVisited) {
        int nexti = i + directions[idx][0];
        int nextj = j + directions[idx][1];
        if (nexti < 0 || nexti >= m || nextj < 0 || nextj >= n) {
            return true;
        }
        if (hasVisited[nexti][nextj])
            return true;
        return false;
    }
}
