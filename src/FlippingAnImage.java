/**
 * 832. Flipping an image
 * @author LBW
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        // flip horizontally
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][n - j - 1];
                A[i][n - j - 1] = tmp;
            }
        }
        // invert
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
