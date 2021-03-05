import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 回溯法
 * @author LBW
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        getResults(candidates, target, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private void getResults(int[] candidates, int target, int i, ArrayList<Integer> cur, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(cur));  /* 注意一定要新建一个ArrayList，因为cur是会变化的!! */
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (target < candidates[j])
                break;
            cur.add(candidates[j]);
            getResults(candidates, target-candidates[j], j, cur, results);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
