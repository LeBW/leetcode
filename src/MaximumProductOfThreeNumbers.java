/**
 * 628. Maximum Product of Three Numbers
 * 用线性扫描找出最大的三个数max1, max2, max3，和最小的两个数 min1, min2.
 * 三个数乘积最大，只会出现在 max1*max2*max3 和 min1*min2*max1 之间。
 * @author LBW
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
        int min1 = Integer.MAX_VALUE, min2 = min1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            }
            else if (nums[i] > max3) {
                max3 = nums[i];
            }
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            }
            else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
