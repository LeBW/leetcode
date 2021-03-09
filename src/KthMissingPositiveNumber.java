/**
 * 1539. Kth Missing Positive Nubmer
 * 数组
 * @author LBW
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int idx = 0;
        int val = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            int count;
            if (i == 0)
                count = arr[0] - 1;
            else
                count = arr[i] - arr[i-1] - 1;
            if (idx + count >= k) {
                break;
            }
            idx += count;
        }
        if (i == 0)
            return k;
        return arr[i - 1] + k - idx;
    }

    // 方法二
    public int findKthPositiveTwo(int[] arr, int k) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] - i - 1 >= k) {
                break;
            }
        }
        return i + k;
    }
}
