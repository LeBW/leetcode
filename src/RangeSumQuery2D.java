/**
 * 304. Range Sum Query 2D - Immutable
 * 二维数组，二位前缀和
 * @author LBW
 */
public class RangeSumQuery2D {
    private int m;
    private int n;
    private int[][] sum;

    public RangeSumQuery2D(int[][] matrix) {
        this.m = matrix.length;
        if (m == 0)
            return;
        this.n = matrix[0].length;
        this.sum = new int[m][n];
        int cur = 0;
        for (int i = 0; i < m; i++) {
            cur += matrix[i][0];
            sum[i][0] = cur;
        }
        cur = 0;
        for (int i = 0; i < n; i++) {
            cur += matrix[0][i];
            sum[0][i] = cur;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - (col1 > 0 ? sum[row2][col1-1] : 0) - (row1 > 0 ? sum[row1-1][col2] : 0) + (col1 > 0 && row1 > 0 ? sum[row1-1][col1-1] : 0);
    }
}
