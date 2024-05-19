import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. Three Sum
 * 1. O(n^2)方法：先排序。两层循环，第一层确定一个数nums[i]，第二层利用O(n)解决“两数之和等于-nums[i]”问题.
 * 2. 如何防止重复是个很重要的问题。在循环过程中，left递增或者right递减，以及第一层循环增加时，都要检查是否与前一个数相同。
 * @author LBW
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序是为了便于去重
        Arrays.sort(nums);
        List<List<Integer>> result  = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                // 说明重复了
                continue;
            }
            twoSum(nums, -nums[i], i + 1, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int target, int start, List<List<Integer>> result) {
        // 因为排序过了，所以可以用双指针找
        int end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start] + nums[end];
            if (tmp == target) {
                List<Integer> cur = new ArrayList<>();
                cur.add(-target);
                cur.add(nums[start]);
                cur.add(nums[end]);
                result.add(cur);
                start += 1;
                while (start < end && nums[start] == nums[start - 1]) {
                    // 去重
                    start += 1;
                }
            } else if (tmp < target) {
                start += 1;
                while (start < end && nums[start] == nums[start - 1]) {
                    // 去重
                    start += 1;
                }
            } else {
                end -= 1;
                while (start < end && nums[end] == nums[end + 1]) {
                    // 去重
                    end -= 1;
                }
            }
        }
    }
}
