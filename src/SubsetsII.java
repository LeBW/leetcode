import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * 1. 在DFS遍历的时候，由于是组合（不是排列），因此要注意每次start的位置，不是从0到n。
 * 2. 注意这里剪枝去重的部分，不需要用到额外的 boolean[] isUsed 数组
 * @author LBW
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        //boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        findSubsets(result, cur, 0, nums);
        result.add(new ArrayList<>());  // add [].
        return result;
    }

    private void findSubsets(List<List<Integer>> result, List<Integer> cur, int start, int[] nums) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1])  // 剪枝去重.
                continue;
            cur.add(nums[i]);
            result.add(new ArrayList<>(cur));
            findSubsets(result, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
