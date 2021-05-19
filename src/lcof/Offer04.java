package lcof;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 思想很巧妙，从右上角的元素入手。
 * @author LBW
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int cur = matrix[i][j];
            if (cur == target) {
                return true;
            }
            else if (cur < target) {
                i += 1;
            }
            else {
                j -= 1;
            }
        }
        return false;
    }
}
