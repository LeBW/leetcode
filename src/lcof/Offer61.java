package lcof;

import java.util.Arrays;

/**
 * Offer 61. 扑克牌中的顺子
 * 模拟吧
 * @author LBW
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int numOfZero = 0;
        while (nums[numOfZero] == 0) {
            numOfZero += 1;
        }
        int maxDistance = 1;
        for (int i = numOfZero + 1; i < 5; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;   // 有相同元素时，直接判不是顺子
            }
            maxDistance = Math.max(maxDistance, nums[i] - nums[i - 1]);
        }
        return maxDistance <= numOfZero + 1;
    }
}
