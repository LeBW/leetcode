package lcof;

/**
 * Offer 51. 数组中的逆序对
 * 思路：用归并排序求逆序对，时间复杂度 O(nlogn)
 * 这个题一开始容易想到的就是暴力求解法，时间复杂度O（n^2），很明显这个不太好。
 * 使用归并排序的思路，可以在O（nlogn）时间内解决这个问题。
 * @author LBW
 */
public class Offer51 {
    // 方法一，暴力法，时间复杂度 O（n^2），比较容易想到
    public int reversePairs(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (cur > nums[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    // 方法二，用归并排序对数组进行排序，过程中就可以求得逆序对的数目了。时间复杂度 O(nlogn)
    private int count = 0;
    public int reversePairsTwo(int[] nums) {
        count = 0;
        int[] tmp = new int[nums.length];
        mergeSort(nums, tmp, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start ) / 2;
        mergeSort(nums, tmp, start, mid);
        mergeSort(nums, tmp, mid + 1, end);
        // start to merge: [start, mid] and [mid + 1, end]
        for (int i = start; i <= end; i++) {
            tmp[i] = nums[i];
        }
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j++];
            }
            else if (j == end + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            }
            else {  // means tmp[i] > tmp[j]
                nums[k] = tmp[j++];
                count += mid - i + 1;
            }
        }
    }

    public static void main(String[] args) {
        Offer51 offer51 = new Offer51();
        offer51.reversePairsTwo(new int[]{7, 5, 6, 4});
    }
}
