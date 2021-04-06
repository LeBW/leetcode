/**
 * 80. Remove Duplicates from Sorted Arrays II
 * 双指针，slow存放结果index，fast存放待检查index。
 * @author LBW
 */
public class RemoveDuplicatesFromSAII {
    // 方法一，自己想出来的蠢办法，两个指针 pre 和 cur，每次遇到3个重复时都会将 cur 后面的数字往前移。
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int res = n;
        if (n < 3)
            return n;
        int pre = 0, cur = 1;
        while (cur + 1 < res) {
            while (cur + 1 < res && nums[pre] == nums[cur] && nums[cur] == nums[cur + 1]) {
                for (int i = cur; i < n - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                res -= 1;
            }
            pre = cur;
            cur = cur + 1;
        }
        return res;
    }

    // 方法二，双指针 slow 和 fast。
    // slow存放结果index，fast存放待检查index。
    public int removeDuplicatesTwo(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return n;
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[fast] != nums[slow - 2]) {
                // 如果 nums[fast] == nums[slow - 2] 的话，说明 nums[slow-2]==nums[slow-1]==...==nums[fast],所以此时的 fast 不能要；反之，则要
                nums[slow++] = nums[fast];
            }
            fast += 1;
        }
        return slow;
    }
}
