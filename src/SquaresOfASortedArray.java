/**
 * 977. Squares of a Sorted Array
 * 双指针
 * @author LBW
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int j = 0, len = A.length;
        while (j < len && A[j] < 0)
            j++;
        int i = j - 1;

        int[] B = new int[len];
        int index = 0;
        while (i >= 0 && j < len) {
            if (A[i] * A[i] <= A[j] * A[j]) {
                B[index] = A[i] * A[i--];
            }
            else {
                B[index] = A[j] * A[j++];
            }
            index += 1;
        }
        while (i >= 0) {
            B[index++] = A[i] * A[i--];
        }
        while (j < len) {
            B[index++] = A[j] * A[j++];
        }
        return B;
    }
}
