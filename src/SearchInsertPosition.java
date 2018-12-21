/**
 * @author LBW
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int l, int r, int target){
        if (l > r) {
            return l;
        }
        else if (l == r) {
            if (nums[l] >= target)
                return l;
            else
                return l + 1;
        }

        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] > target) {
            return find(nums, l, mid - 1, target);
        }
        else {
            return find(nums, mid + 1, r, target);
        }
    }
}
