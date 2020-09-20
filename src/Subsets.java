import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 78. Subsets
 * 递归
 * @author LBW
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        result.add(new ArrayList<Integer>());
        for (; i < nums.length; i++) {
            int l = result.size();
            for (int j = 0; j < l; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }

    /**
     * 方法二：回溯法。将其想象为一棵n叉树，每个节点都可以选择或者不选。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsII(int[] nums) {
        // backTrack
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backTrack(nums, 0, cur, res);
        return res;
    }

    private void backTrack(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        if (idx == nums.length)
            return;
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            backTrack(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
