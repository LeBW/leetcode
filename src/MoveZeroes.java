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

    // 更简便的方法
    public void moveZeroes2(int[] nums) {
        int len = nums.length;
        // cur 从 0 开始，记录需要处理的索引
        int cur = 0;
        // 遍历数组 nums，遇到非 0 时，将其设置到 nums[cur] 中，并将 cur 加 1
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur += 1;
            }
        }
        // 遍历完成后，nums[cur] 前面的全部都是非零元素，后面的应该全部设置为 0
        while (cur < len) {
            nums[cur++] = 0;
        }
    }
}
