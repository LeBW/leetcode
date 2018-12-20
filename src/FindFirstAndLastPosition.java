/**
 * @author LBW
 */
public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int l = 0, r = nums.length - 1;
        return find(nums, l, r, target);
    }

    private int[] find(int[] nums, int l, int r, int target) {
        if (l > r || (l==r && nums[l] != target))
            return new int[]{-1, -1};
        else if (l == r && nums[l] == target) {
            return new int[]{l, l};
        }
        int mid = (l + r) / 2;
        if (nums[mid] > target) {
            return find(nums, l, mid - 1, target);
        }
        else if (nums[mid] < target) {
            return find(nums, mid + 1, r, target);
        }
        else {
            int left = findLeft(nums, l, mid, target);
            int right = findRight(nums, mid, r, target);
            return new int[]{left, right};
        }
    }
    private int findLeft(int[] nums, int l, int r, int target) {
        if (l == r)
            return r;
        int mid = (l + r) / 2;
        if (nums[mid] < target) {
            return findLeft(nums, mid + 1, r, target);
        }
        else {
            return findLeft(nums, l, mid, target);
        }
    }
    private int findRight(int[] nums, int l, int r, int target) {
        if (l >= r)
            return l;
        int mid = (l + r + 1) / 2;
        if (nums[mid] > target) {
            return findRight(nums, l, mid - 1, target);
        }
        else {
            return findRight(nums, mid, r, target);
        }
    }
}
