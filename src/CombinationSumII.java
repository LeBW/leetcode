import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * @author LBW
 */
public class CombinationSumII {
    private List<List<Integer>> result;
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 初始化
        result = new ArrayList<>();
        this.candidates = candidates;
        // 对数组排序 （方便剪枝）
        Arrays.sort(candidates);
        // 开始回溯
        List<Integer> cur = new ArrayList<>();
        findCombinationSum(0, target, cur, 0);
        return result;
    }

    private void findCombinationSum(int start, int target, List<Integer> cur, int sum) {
        // 找到结果，添加并结束
        if (sum == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        // 遍历 + 回溯
        int i = start;
        while (i < candidates.length && sum + candidates[i]<= target) {
            if (i > start && candidates[i] == candidates[i-1]) { // 说明在*同一层*遇到了相同元素，需要剪枝。
                i += 1;
                continue;
            }
            cur.add(candidates[i]);
            sum += candidates[i];
            findCombinationSum(i + 1, target, cur, sum);
            sum -= candidates[i];
            cur.remove(cur.size()-1);
            i += 1;
        }
    }
}
