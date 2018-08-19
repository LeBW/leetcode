/**
 * <a href=https://leetcode-cn.com/problems/trapping-rain-water/description/>
 * Click to see online description
 * </a>
 * <br>
 * @author LBW
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2)
            return 0;

        int result = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        //genarete left
        left[0] = 0;
        left[1] = height[0];
        int max = height[0];
        for (int i = 2; i < n; i++) {
            if (height[i-1] > max)
                max = height[i-1];
            left[i] = max;
        }
        //generate right
        right[n-1] = 0;
        right[n-2] = height[n-1];
        max = height[n-1];
        for (int i = n-3; i >= 0; i--) {
            if (height[i+1] > max)
                max = height[i+1];
            right[i] = max;
        }

        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            int t = min - height[i] > 0 ? min-height[i] : 0;
            result += t;
        }
        return result;
    }
}
