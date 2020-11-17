/**
 * 1030. Matrix Cells in Distance Order
 * 模拟法。从(r0, c0)坐标开始，向外画圈圈
 * @author LBW
 */
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int n = R * C;
        // find the largest distance max
        int max = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int[][] res = new int[n][2];
        res[0] = new int[]{r0, c0};
        int idx = 1;
        // traverse by distance from 1 to max
        for (int d = 1; d <= max; d++) {
            int r = r0 - d, c = c0;
            for (int i = 0; i < d; i++) {
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    res[idx++] = new int[]{r, c};
                }
                r += 1;
                c += 1;
            }
            for (int i = 0; i < d; i++) {
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    res[idx++] = new int[]{r, c};
                }
                r += 1;
                c -= 1;
            }
            for (int i = 0; i < d; i++) {
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    res[idx++] = new int[]{r, c};
                }
                r -= 1;
                c -= 1;
            }
            for (int i = 0; i < d; i++) {
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    res[idx++] = new int[]{r, c};
                }
                r -= 1;
                c += 1;
            }
        }
        return res;
    }
}
