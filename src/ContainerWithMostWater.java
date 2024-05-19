/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate(i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis froms a container, such that the container contains the most water.
 *
 * 11. Container With Most Water
 * 双指针法。
 * 注意方法。暴力法不可取，时间复杂度O（n^2）.
 * 设置两个指针分别指向首尾，逐步往中间逼近即可（每次选取高度较小的那一侧，往中间逼近）
 * 该方法证明正确性的主要思路是：每次将高度较小的那一侧往中间逼近时，所消去的状态都是不可能是最大值的。
 * @author LBW
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            if (height[start] < height[end]) {
                start += 1;
            } else {
                end -= 1;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 2, 3, 4, 5}));
    }
}
