/**
 * 283. Move Zeroes
 * @author LBW
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0, len = 0;
        while (idx < n && nums[idx] != 0) {
            idx += 1;
        }
        if (idx == n)
            return;
        len = 1;  // 此时 nums[idx]指向第一个0
        while (idx + len < n) {
            if (nums[idx + len] == 0) {
                len += 1;
            }
            else {
                nums[idx] = nums[idx + len];
                for (int j = idx + 1; j <= idx + len; j++) {
                    nums[j] = 0;
                }
                idx += 1;
            }
        }

    }
}
