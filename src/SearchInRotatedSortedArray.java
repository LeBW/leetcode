/**
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
}
