import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. Largest Rectangle in Histogram
 * @author LBW
 */
public class LargestRectangleInHistogram {
    /**
     * 方法一，暴力解法，尝试每一个区间[i, j]里的最大面积，取最大值。
     * 时间复杂度 O(n^2).
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                res = Math.max(res, minHeight * (j - i + 1));
            }
        }
        return res;
    }

    /**
     * 方法二：单调栈。
     * 单调栈里面，在弹出每一个元素cur的时候，可以知道它左边和右边第一个比它小的数字（索引），有这个信息就可以算出以heights[cur]为高度的最大矩形面积了。
     * @param heights
     * @return
     */
    public int largestRectangleAreaTwo(int[] heights) {
        int n = heights.length;
        if (n < 1)
            return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    res = Math.max(res, heights[cur] * i);
                }
                else {
                    res = Math.max(res, heights[cur] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (stack.isEmpty()) {
                res = Math.max(res, heights[cur] * n);
            }
            else {
                res = Math.max(res, heights[cur] * (n - stack.peek() - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        largestRectangleInHistogram.largestRectangleAreaTwo(nums);
    }
}
