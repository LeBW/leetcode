package lcof;

/**
 * Offer 53. 在排序数组中查找数字
 * 二分法寻找 target 的最左边和最右边。
 * 注意这里不要转化为求 target 左边 或者 右边 的值，而要直接求 target 本身的 左右 index，否则转换起来非常非常麻烦。
 *
 * 而求 target 左边的第一个值 ，和求 target 本身的左 index，两个看起来只差 1，其实在写二分的时候，相差甚远。
 * @author LBW
 */
public class Offer53 {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target))
            return 0;
        int left = findLeft(nums, target);
        if (left == -1) {
            return 0;
        }
        int right = findRight(nums, target);
        return right - left + 1;
    }

    /*
    寻找 nums 数组中 target 出现的最左边。如果没有的话，返回 -1
     */
    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }

    /*
    寻找 nums 数组中 target 出现的最右边。如果没有的话，返回 -1
     */
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }
}
