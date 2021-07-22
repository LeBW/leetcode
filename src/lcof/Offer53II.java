package lcof;

/**
 * 0 ~ n - 1 中缺失的数字
 * 二分法
 * @author LBW
 */
public class Offer53II {
    // 一开始的思路，时间复杂度 O（n）
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int[] tmp = new int[n];
        for (int num: nums) {
            tmp[num] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (tmp[i] == 0)
                return i;
        }
        return -1;
    }

    // 排序数组中搜素数字，应该想到二分法
    public int missingNumberTwo(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        // left 指向右半数组的第一个（如果存在的话）
        return nums[left] == left ? left + 1 : left;
    }
}
