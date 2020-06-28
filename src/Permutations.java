import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * 全排列。回溯法（dfs）
 * @author LBW
 */
public class Permutations {
    private int len;
    private List<List<Integer>> result;
    private boolean[] used;
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        // 初始化全局变量
        this.nums = nums;
        len = nums.length;
        used = new boolean[len];
        result = new ArrayList<>();
        // 初始化递归变量
        List<Integer> cur = new ArrayList<>();
        backTrack(cur);
        return result;
    }

    private void backTrack(List<Integer> cur) {
        // 已经找满了，结束递归
        if (cur.size() == len) {
            result.add(new ArrayList(cur));  // 拷贝
            return;
        }
        // 还没满，继续递归
        for (int i = 0; i < len; i++) {
            // 没用过的数，都得用
            if (!used[i]) {
                used[i] = true;
                cur.add(nums[i]);
                backTrack(cur);
                // 递归完成后，要还原（这就是回溯）
                cur.remove(new Integer(nums[i]));  //这里用 new Integer，来保证remove掉的是值，不是index
                used[i] = false;
            }
        }
    }
}
