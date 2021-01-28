/**
 * 724. Find Pivot Index
 * 数组
 * @author LBW
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int idx = 0;
        int left = 0, right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        while (idx < nums.length - 1 && left != right) {
            left += nums[idx];
            idx += 1;
            right -= nums[idx];
        }
        if (left == right) {
            return idx;
        }
        return -1;
    }
}
