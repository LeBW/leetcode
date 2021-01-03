import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 * 单调递减双端队列，类似于单调栈
 * @author LBW
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //单调递减双端队列
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        for (int i = 1; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
        }
        int n = nums.length - k + 1;
        int[] res = new int[n];
        res[0] = nums[queue.peek()];
        for (int i = 1; i < n; i++) {
            // push i + k - 1
            while (!queue.isEmpty() && nums[i + k - 1] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i + k - 1);
            // 如果队首是最大值，踢掉
            while (queue.peek() < i) {
                queue.poll();
            }
            res[i] = nums[queue.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
