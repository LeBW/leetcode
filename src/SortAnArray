/**
 * <a href=https://leetcode-cn.com/problems/sort-an-array/>https://leetcode-cn.com/problems/sort-an-array/</a>
 * 目前的实现方式：快速排序。
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(nums, start, end);
        quickSort(nums, start, p-1);
        quickSort(nums, p+1, end);


    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start, j = end;

        while (i < j) {
            // from tail to head
            for (; i < j && nums[j] >= pivot; j--);
            nums[i] = nums[j];
            // from head to tail
            for (; i < j && nums[i] <= pivot; i++);
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
}