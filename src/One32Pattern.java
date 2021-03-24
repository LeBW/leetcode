import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 456. 132 Pattern
 * 单调栈。
 * @author LBW
 */
public class One32Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;
        int[] min = new int[n];   // min[i] 维护的是 nums[0:i]中最小的数
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        Deque<Integer> stack = new ArrayDeque<>();  // 从右往左遍历的单调递减栈，在遍历到 j 的时候，相当于找 j 后面比 min[j] 大的最小数
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && stack.peek() <= min[j]) {  // 这里相当于找 j 后面比 min[j] 大的最小数
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < nums[j]) {
                return true;
            }
            stack.push(nums[j]);
        }
        return false;
    }
}
