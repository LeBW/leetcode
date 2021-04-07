/**
 * 33. Search in Rotated Sorted Array
 * 二分查找法。
 * 在找到 mid 之后，至少有一侧：[left, mid] 或者 [mid, right] 是有序的。
 * 所以我们可以先判断在不在有序的这一侧（if），从而决定接下来在哪一侧寻找。
 * @author LBW
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        int result = findIn(nums, 0, len-1, target);
        return result;
    }

    private int findIn(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;
        else if (l == r)
            return nums[l] == target ? l : -1;
        if (nums[l] == target)
            return l;
        if (nums[r] == target)
            return r;

        int mid = (l + r) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[mid] > nums[l]) {        // the rotate part is in right part.
            if (target > nums[l] && target < nums[mid]) {
                return binarySearch(nums, l+1, mid-1, target);
            }
            else {
                return findIn(nums, mid+1, r-1, target);
            }
        }
        else {
            if (target > nums[mid] && target < nums[r]) {
                return binarySearch(nums, mid+1, r-1, target);
            }
            else {
                return findIn(nums, l+1, mid-1, target);
            }
        }
    }
    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;
        else if (l == r)
            return nums[l] == target ? l : -1;

        if (nums[l] == target)
            return l;
        else if (nums[r] == target)
            return r;

        int mid = (l + r) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return binarySearch(nums, l+1, mid-1, target);
        else
            return binarySearch(nums, mid+1, r-1,  target);
    }


    // 方法二：标准的二分查找
    public int searchTwo(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; // 这里的 mid 是向下取整
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) { // 说明[left, mid]是有序的
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { // 说明 [mid, right] 是有序的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }}
