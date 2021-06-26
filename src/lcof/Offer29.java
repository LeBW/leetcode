package lcof;

/**
 * Offer29. 顺时针打印矩阵
 * 模拟
 * @author LBW
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        int idx = 0;
        int i = 0, j = 0;
        int[] res = new int[m * n];
        res[0] = matrix[0][0];
        hasVisited[0][0] = true;
        for (int k = 1; k < m * n; k++) {
            if (shouldRotate(i + directions[idx][0], j + directions[idx][1], m, n, hasVisited)) {
                idx = (idx + 1) % 4;
            }
            i = i + directions[idx][0];
            j = j + directions[idx][1];
            hasVisited[i][j] = true;
            res[k] = matrix[i][j];
        }
        return res;
    }

    private boolean shouldRotate(int i, int j, int m, int n, boolean[][] hasVisited) {
        return i < 0 || i >= m || j < 0 || j >= n || hasVisited[i][j];
    }
}
