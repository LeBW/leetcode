/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate(i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis froms a container, such that the container contains the most water.
 *
 * @author LBW
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int max = 0;
        while (i < j) {
            int area;
            if (height[i] < height[j]) {
                area = height[i] * (j - i);
                i++;
            }
            else {
                area = height[j] * (j - i);
                j--;
            }
            if (area > max)
                max = area;
        }
        return max;
    }
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 2, 3, 4, 5}));
    }
}
