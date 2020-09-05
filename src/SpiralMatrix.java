import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * 数组。
 * @author LBW
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1,}, {-1, 0}}; // indicate four directions
        int idx = 0; // indicate current direction.(right)
        boolean[][] isVisited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        for (int k = 0; k < m * n; k++) {
            res.add(matrix[i][j]);
            isVisited[i][j] = true;
            if (i + directions[idx][0] >= 0 && i + directions[idx][0] < m && j + directions[idx][1] >= 0 && j + directions[idx][1] < n && !isVisited[i + directions[idx][0]][j + directions[idx][1]]) {
                i += directions[idx][0];
                j += directions[idx][1];
            }
            else {
                idx = (idx + 1) % 4;  //change direction.
                i += directions[idx][0];
                j += directions[idx][1];
            }
        }
        return res;
    }
}
