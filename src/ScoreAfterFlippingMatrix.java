/**
 * 861. Score After Flipping Matrix
 * @author LBW
 */
public class ScoreAfterFlippingMatrix {
    // 贪心策略：先对行移动，保证最高位都是1；然后对列移动，保证大部分都是1
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                reverseRow(A, i);
            }
        }
        int factor = (int)Math.pow(2, n - 1);
        int sum = m * factor, mid = (m + 1) / 2;
        for (int j = 1; j < n; j++) {
            int numberOfOne = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 1) {
                    numberOfOne += 1;
                }
            }
            if (numberOfOne < mid) {
                reverseColume(A, j);
                numberOfOne = m - numberOfOne;
            }
            factor = factor / 2;
            sum += numberOfOne * factor;
        }
        return sum;
    }

    private void reverseRow(int[][] A, int i) {
        for (int j = 0; j < A[i].length; j++) {
            A[i][j] = A[i][j] == 0 ? 1 : 0;
        }
    }

    private void reverseColume(int[][] A, int j) {
        for (int i = 0; i < A.length; i++) {
            A[i][j] = A[i][j] == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        ScoreAfterFlippingMatrix scoreAfterFlippingMatrix = new ScoreAfterFlippingMatrix();
        scoreAfterFlippingMatrix.matrixScore(A);
    }
}
