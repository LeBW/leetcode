import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * 回溯+剪枝，比46题多一个剪枝的过程。
 * 注意：要剪枝，首先要排序，才好剪。
 * @author LBW
 */
public class PermutationII {
    private List<List<Integer>> result;
    private int len;
    private boolean[] used;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 初始化
        this.nums = nums;
        result = new ArrayList<>();
        len = nums.length;
        used = new boolean[len];
        // 开始递归回溯
        List<Integer> cur = new ArrayList<>();
        backTrack(cur);

        return result;
    }

    private void backTrack(List<Integer> cur) {
        if (cur.size() == len) {
            result.add(new ArrayList(cur));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                System.out.println(cur.toString() + nums[i]);
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1])
                    continue;
                used[i] = true;
                cur.add(nums[i]);
                backTrack(cur);
                cur.remove(cur.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationII permutationII = new PermutationII();
        List<List<Integer>> result = permutationII.permuteUnique(new int[]{2, 2, 1, 1});
        System.out.println(result);
    }
}
