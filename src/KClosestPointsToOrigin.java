import java.util.Arrays;

/**
 * 973. K Closest Points to Origin
 * @author LBW
 */
public class KClosestPointsToOrigin {
    /* 模拟快排的思想，只不过每次只比较一半。时间复杂度O(n) */
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        quickSort(points, 0, n-1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSort(int[][] points, int start, int end, int K) {
        if (start >= end)
            return;
        int[] pivot = points[start];
        int pivotVal = points[start][0] * points[start][0] + points[start][1] * points[start][1];
        int i = start, j = end;
        while (i < j) {
            while (i < j && points[j][0] * points[j][0] + points[j][1] * points[j][1] > pivotVal)
                j--;
            points[i] = points[j];
            while (i < j && points[i][0] * points[i][0] + points[i][1] * points[i][1] <= pivotVal)
                i++;
            points[j] = points[i];
        }
        points[i] = pivot;
        // 与快排不同的是，这里我们比较i与K的大小关系，从而决定在哪一块继续快排，而不需要对所有元素进行比较排序。
        if (K - 1 < i) {
            quickSort(points, start, i-1, K);
        }
        else if (K - 1 > i) {
            quickSort(points, i+1, end, K);
        }
    }
}
