package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer 57-II. 和为s的连续正数序列
 * 滑动窗口
 * @author LBW
 */
public class Offer57II {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[][]{{}};
        }
        int i = 1, j = 2, sum = 3;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        cur.add(2);
        while (i < j) {
            if (sum == target) {
                res.add(new ArrayList<>(cur));
                j += 1;
                cur.add(j);
                sum += j;
            }
            else if (sum > target) {
                cur.remove(0);
                sum -= i;
                i += 1;
            }
            else {
                j += 1;
                cur.add(j);
                sum += j;
            }
        }
        int[][] ans = new int[res.size()][];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = new int[res.get(k).size()];
            for (int k1 = 0; k1 < res.get(k).size(); k1++) {
                ans[k][k1] = res.get(k).get(k1);
            }
        }
        return ans;
    }
}
