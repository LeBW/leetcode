/**
 * <a href=https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/>
 * Click to see online description
 * </a>
 * <br>
 *     答案的方法比较巧妙，使用双指针法，避免了数组的移动.
 * @author LBW
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == nums[i-1]) {
                int repeatCount = 0;
                int j = i;
                for (; j < len && nums[j] == nums[i-1]; j++) {
                    repeatCount++;
                }
                while (j < len) {
                    nums[j-repeatCount] = nums[j];
                    j++;
                }
                len -= repeatCount;
            }
        }
        return len;
    }

    public int standardSolution(int[] nums) {
        //双指针法
        int n = nums.length;
        if (n < 2)
            return n;
        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
            fast += 1;
        }
        return slow;
    }
}
