package lcof;

/**
 * Offer 40. 最小的 k 个数
 * 求数组中最小的 k 个数：
 * 1. 快排的思想，分治解决，把问题转换为找到第 k 小的数，那么前面就全部是比 k 小的数了。时间复杂度 O（n）
 * 2. 堆的思想，维护一个大根堆，初始化为数组中前 k 个数；往后遍历的过程中，如果数字比堆顶小，那么弹出堆顶，将该数字插入数组。时间复杂度 O（nlogk）
 * @author LBW
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[]{};
        }
        int n = arr.length;
        int num = findKthSmall(arr, 0, n - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private int findKthSmall(int[] arr, int start, int end, int k) {
        int pivot = arr[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
        }
        arr[left] = pivot;
        if (left + 1 == k) {
            return arr[left];
        }
        else if (left + 1 < k) {
            return findKthSmall(arr, left + 1, end, k);
        }
        else {
            return findKthSmall(arr, start, left - 1, k);
        }
    }

}
