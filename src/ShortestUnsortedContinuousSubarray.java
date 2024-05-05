/**
 * 总体思路是将数组分为三个部分：nums1, nums2, nums3
 * 其中 nums1 和 nums3 是有序的，而 nums2 是无序的。
 * 例如对于 nums = [2,6,4,8,10,9,15]，我们可以分为 [2], [6,4,8,10,9], [15] 三部分
 * 所以具体思路是：
 * 1. 找到倒序的左右端点 left，right
 * 2. 找到 nums[left, right] 部分的最小值 min 和最大值 max
 * 3. 根据 min 对 left 进行扩充；根据 max 对 right 进行扩充。
 * @author LBW
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }
        if (left == -1) { // 说明数组已经是有序的
            return 0;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                right = i;
                break;
            }
        }
        // 此时 left 和 right 已经是不满足的两个端点了，但是考虑到 [1, 3, 2, 2, 2] 这种情况，left 和 right 可能还要扩充
        // 这里的思路是找到 nums[left, right] 区间内的最大值 max 和 最小值 min，然后 left 需要根据 min 往左扩充，right 需要根据 max 往右扩充
        int max = nums[left], min = nums[left];
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        while (left > 0 && nums[left - 1] > min) {
            left -= 1;
        }
        while (right < nums.length - 1 && nums[right + 1] < max) {
            right += 1;
        }
        return right - left + 1;
    }

}
