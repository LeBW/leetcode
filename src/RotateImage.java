/**
 * 48. Rotate Image
 * 顺时针旋转90度：先转置（对角），再左右翻转（每一行进行左右翻转即可）
 * @author LBW
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        // transpose the matrix
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // reverse every line
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
