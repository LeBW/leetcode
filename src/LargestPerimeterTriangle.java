import java.util.Arrays;

/**
 * 976. Largest Perimeter Triangle
 *  贪心法则。先对数组进行排序，然后从最大值开始遍历：
 * 	 将最大值作为一边，如果能组成三角形的话，那么一定是和i-1和i-2组成时周长最大，那么看这个能不能组成三角形即可（即是否 A[i-2] + A[i-1] > A[i] ).
 * @author LBW
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for (int i = n - 1; i >= 2; i--) {
            if (A[i-2] + A[i-1] > A[i]) {
                return A[i-2] + A[i-1] + A[i];
            }
        }
        return 0;
    }
}
