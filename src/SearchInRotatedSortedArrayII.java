/**
 * 81. Search in Rotated Sorted Array II.
 * 二分查找法。（带去重）
 * 因为数组中可能有重复，所以当 nums[mid] == nums[left] 或 nums[mid] == nums[right] 时，不能判断哪边有序。此时我们直接将下标 +- 1，进行去重处理。
 * @author LBW
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[left]) {   // 此时需要去重
                left += 1;
            }
            else if (nums[mid] == nums[right]) {  // 此时需要去重
                right -= 1;
            }
            else if (nums[mid] > nums[left]) { // 说明 [left, mid] 是有序的
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { // 说明 [mid, right] 是有序的
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        if (target == nums[left]) {
            return true;
        }
        return false;
    }
}
