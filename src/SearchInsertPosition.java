/**
 * 35. Search Insert Position
 * 二分查找，经典题目。
 * @author LBW
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1;
        // 特殊情况，所有元素都小于target，于是target需要插在末尾
        if (target > nums[right])
            return n;
        // 普通情况下，找出【大于等于】target的最小值下标，这就是需要插入的地方
        while (left < right) {
            int mid = (left + right) / 2;  // 因为right不会桌主动向左偏，所以mid需要向下取整（向左偏）
            if (nums[mid] < target) { // 排除
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
