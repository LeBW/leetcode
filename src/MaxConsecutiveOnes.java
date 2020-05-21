/**
 * 485. Max Consecutive Ones.
 * @author LBW
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur += 1;
            }
            else {
                if (cur > max) {
                    max = cur;
                }
                cur = 0;
            }
        }
        if (cur > max) {
            max = cur;
        }
        return max;
    }
}
