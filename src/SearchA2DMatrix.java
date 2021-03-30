/**
 * 74. Search a 2D Matrix
 * 二分查找
 * @author LBW
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target < matrix[i][0]) {
                return false;
            }
            if (target == matrix[i][0] || target == matrix[i][n - 1]) {
                return true;
            }
            if (target < matrix[i][n - 1]) {
                return search(matrix[i], 0, n - 1, target);
            }
            // else target > matrix[i][1], continue.
        }
        return false;
    }

    private boolean search(int[] arr, int start, int end, int target) {
        if (start > end)
            return false;
        int mid = start + (end - start) / 2;
        if (target == arr[mid])
            return true;
        if (target < arr[mid]) {
            return search(arr, start, mid - 1, target);
        }
        return search(arr, mid + 1, end, target);
    }
}
