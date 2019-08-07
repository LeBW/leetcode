/**
 * <a href=https://leetcode-cn.com/problems/trapping-rain-water/description/>
 * Click to see online description
 * </a>
 * <br>
 * @author LBW
 */
public class TrappingRainWater {
    /**
     * 方法一：暴力法.
     * 时间复杂度O(n^2)。空间复杂度O(1).
     */
    public int trapOne(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = findMaxLeft(height, i);
            int rightMax = findMaxRight(height, i);
            int temp = Math.min(leftMax, rightMax) - height[i];
            if (temp > 0)
                result += temp;
        }
        return result;
    }
    public int findMaxLeft(int[] height, int i) {
        int max = 0;
        for (int j = i-1; j >= 0; j--) {
            if (height[j] > max)
                max = height[j];
        }
        return max;
    }
    public int findMaxRight(int[] height, int i) {
        int max = 0;
        for (int j = i + 1; j < height.length; j++) {
            if (height[j] > max)
                max = height[j];
        }
        return max;
    }

    /**
     * 方法二：动态规划。
     * 时间复杂度O(n), 空间复杂度O(n)
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        // generate leftMax.
        int curMax = 0;
        for (int i = 0; i < len; i++) {
            if (height[i] > curMax) {
                curMax = height[i];
            }
            leftMax[i] = curMax;
        }
        // generate rightMax
        curMax = 0;
        for (int i = len-1; i >= 0; i--) {
            if (height[i] > curMax) {
                curMax = height[i];
            }
            rightMax[i] = curMax;
        }
        // get the result.
        int result = 0;
        for (int i = 1; i < len-1; i++) {
            int temp = Math.min(leftMax[i-1], rightMax[i+1]) - height[i];
            if (temp > 0)
                result += temp;
        }
        return result;
    }
    /**
     * 方法三：动态规划+双指针。 (十分巧妙！）
     * 时间复杂度O(n)，空间复杂度O(1).
     * 关键点：维护两个指针left和right以及两个当前最大值leftMax和rightMax.
     * 初始化:
     * left=1,leftMax = height[left];
     * right=len-1, rightMax = height[right];
     * 循环过程中：判断leftMax和rightMax从而确定从左边更新还是从右边更新。
     * 循环len-2次后，得到结果。
     */
    public int trapThree(int[] height) {
        int len = height.length;
        if (len == 0)
            return 0;
        int left = 0, right = len-1;
        int leftMax = height[left], rightMax = height[right];
        int result = 0;
        for (int i = 1; i <= len-2; i++) {
            if (leftMax <= rightMax) {
                // 此时确定(left+1)处的积水，因为此时leftMax小于后面的rightMax,那么一定小于真正的rightMax
                left = left + 1;
                int temp = leftMax - height[left];
                if (temp > 0)
                    result += temp;
                else
                    leftMax = height[left];
            }
            else {
                // 此时确定(right-1)处的积水，因为此时rightMax小于前面的leftMax,那么一定小于真正的leftMax.
                right = right - 1;
                int temp = rightMax - height[right];
                if (temp > 0)
                    result += temp;
                else
                    rightMax = height[right];
            }
        }
        return result;
    }
}
