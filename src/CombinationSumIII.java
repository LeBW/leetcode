import java.util.ArrayList;
import java.util.List;

/**
 * @author LBW
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        findCombinationSum3(result, cur, 1, k, n);
        return result;
    }

    private void findCombinationSum3(List<List<Integer>> result, List<Integer> cur, int start, int k, int target) {
        if (target < 0) {
            return;
        }
        if (k == 0) {
            if (target == 0) {
                result.add(new ArrayList(cur));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target)
                continue;
            cur.add(i);
            findCombinationSum3(result, cur, i + 1, k - 1, target - i);
            cur.remove(cur.size()-1);
        }
    }
}
