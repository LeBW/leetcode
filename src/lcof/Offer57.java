package lcof;

/**
 * Offer 57. 和为 s 的两个数字
 * 双指针碰撞
 * @author LBW
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int s = nums[left] + nums[right];
            if (s == target) {
                return new int[]{nums[left], nums[right]};
            }
            else if (s > target) {
                right -= 1;
            }
            else if (s <  target) {
                left += 1;
            }
        }
        return new int[0];
    }
}
