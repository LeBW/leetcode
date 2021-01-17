/**
 * 221. Maximal Square
 * @author LBW
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int square = findLargestSquare(i, j, m, n, matrix);
                res = Math.max(square, res);
            }
        }
        return res;
    }
    // 往[i, j]的右下方寻找最大的全1方针
    private int findLargestSquare(int i, int j, int m, int n, char[][] matrix) {
        if (matrix[i][j] == '0')
            return 0;
        int ring = 1;
        boolean flag = true;
        while (flag) {
            if (i + ring >= m || j + ring >= n) {
                flag = false;
                break;
            }
            for (int k = 0; k <= ring; k++) {
                if (!(matrix[i + ring][j + k] == '1')) {
                    flag = false;
                    break;
                }
                if (!(matrix[i + k][j + ring] == '1')) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ring += 1;
        }
        return ring * ring;
    }
}
