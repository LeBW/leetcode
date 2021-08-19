import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode.com/problems/4sum/description/>
 * 18. Four Sum
 * 两种方法：1. 回溯，时间复杂度O(n^4)。2. 类似三数之和，先排序，然后两层遍历 + 一层双指针，时间复杂度 O（n^3）
 * </a>
 *<br>
 * @author LBW
 */
public class FourSum {
    /**
     * 类似三数之和，先排序，然后两层遍历 + 一层双指针。时间复杂度 O(n^3)。
     */
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

    /**
     * 排序 + 回溯。时间复杂度 O(n^4)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSumTwo(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backTrack(nums, 0, cur, target, res);
        return res;
    }

    private void backTrack(int[] nums, int idx, List<Integer> cur, int target, List<List<Integer>> res) {
        if (cur.size() == 4) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i -1]) {
                continue;
            }
            cur.add(nums[i]);
            backTrack(nums, i + 1, cur, target - nums[i], res);
            cur.remove(cur.size() - 1);
        }
    }
}
