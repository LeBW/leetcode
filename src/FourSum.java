import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode.com/problems/4sum/description/>
 * Click here to see online description.
 * </a>
 *<br>
 * Like 3Sum. Time complexity: O(n^3)
 *
 * @author LBW
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //sort the nums array.
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int t1 = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                int t2 = nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (t1 + t2 + nums[left] + nums[right] < target) {
                        left++;
                        while (left < right && nums[left] == nums[left-1])
                            left++;
                    }
                    else if (t1 + t2 + nums[left] + nums[right] > target) {
                        right--;
                        while (left < right && nums[right] == nums[right+1])
                            right--;
                    }
                    else {
                        results.add(Arrays.asList(t1, t2, nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left-1])
                            left++;
                        while (left < right && nums[right] == nums[right+1])
                            right--;
                    }
                }
            }
        }
        return results;
    }
}
