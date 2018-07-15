import java.util.Arrays;

/**
 * @author LBW
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int nextTarget = target - nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (Math.abs(sum - nextTarget) < Math.abs(result - target)) {
                    result = nums[i] + sum;
                }

                if (sum == nextTarget) {
                    return result;
                }
                else if (sum < nextTarget) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
