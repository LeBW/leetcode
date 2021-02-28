/**
 * 896. Monotonic Array
 * @author LBW
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if (n < 2)
            return true;
        int increased = 0; // 1 代表递增，-1 代表递减，0 代表相等
        for (int i = 0; i < n - 1; i++) {
            if (increased == 1 && A[i] > A[i + 1])
                return false;
            if (increased == -1 && A[i] < A[i + 1])
                return false;
            if (increased == 0 && A[i] != A[i + 1]) {
                increased = A[i] < A[i + 1] ? 1 : -1;
            }
        }
        return true;
    }
}
