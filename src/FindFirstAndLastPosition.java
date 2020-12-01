/**
 * 34. Find first and Last Position of Element in Sorted Array.
 * 二分查找。细节满满。
 * 需要注意，在二分法逼近的时候，分两种情况：
 * 1. left = mid+1, right = mid. 这种逼近的时候，rihgt不会主动向左逼近，为了防止死循环，mid需要向下取整（偏左）。
 * 2. left = mid, right = mid - 1. 这种逼近的时候，left不会主动向右逼近，为了防止死循环，mid需要向上取整（偏右）。
 * @author LBW
 */
public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int left = findLeft(nums, target);
        if (left == -1)
            return new int[]{-1, -1};
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] == target) {
                right = mid;
            }
            else {
                right = mid - 1;
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }

    private int findRight(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] == target) {
                left = mid;
            }
            else {
                left = mid + 1;
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        FindFirstAndLastPosition findFirstAndLastPosition = new FindFirstAndLastPosition();
        findFirstAndLastPosition.searchRange(nums, 8);
    }


    //老办法。递归。
    private int findLeftTarget(int[] nums, int l, int r, int target) {
        if (l > r || (l == r && nums[l] != target))
            return -1;
        else if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] > target) {
            return findLeftTarget(nums, l, mid-1, target);
        }
        else if (nums[mid] < target) {
            return findLeftTarget(nums, mid+1, r, target);
        }
        else {
            return findLeftTarget(nums, l, mid, target);
        }
    }
    private int findRightTarget(int[] nums, int l, int r, int target) {
        if (l > r || (l == r && nums[l] != target))
            return -1;
        else if (l == r)
            return r;
        int mid = (l + r + 1) / 2;
        if (nums[mid] > target) {
            return findRightTarget(nums, l, mid-1, target);
        }
        else if (nums[mid] < target) {
            return findRightTarget(nums, mid+1, r, target);
        }
        else {
            return findRightTarget(nums, mid, r, target);
        }
    }
}
