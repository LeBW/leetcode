/**
 * 215. Kth Largest Element in an Array
 * 方法一：利用快排的思想，不过每次只找一半。
 * 方法二：建一个最大堆，删除元素k-1次，栈顶就是答案
 * 时间复杂度都是O(n)
 * @author LBW
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length + 1 - k);
    }

    private int findKthSmallest(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        int i = start, j = end;
        while (i < j) {
            for (; i < j && nums[j] >= pivot; j--);
            if (i < j) {
                nums[i] = nums[j];
            }
            for (; i < j && nums[i] <= pivot; i++);
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = pivot;
        if (k == i + 1) {
            return nums[i];
        }
        else if (k < i + 1) {
            return findKthSmallest(nums, start, i - 1, k);
        }
        else {
            return findKthSmallest(nums, i + 1, end, k);
        }
    }
}
