package contest;

import java.util.Arrays;

/**
 * 5852. Minimize the Difference Between Target and Chosen Elements
 * 记忆化搜索 + 剪枝
 * 1. 先对每一行排序，方便后面的剪枝。
 * 2. 初始化记忆化数组 memo[m][target + 1]，用于存储中间结果
 * 3. 对二维数组进行回溯查找
 * @author LBW
 */
public class MinimizetheDifferenceBTACE {
    private int res;
    private int[][] memo;

    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(mat[i]);
        }
        memo = new int[m][target + 1];  // 用来进行记忆化回溯，去除重复计算
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return traverse(mat, 0, target);
    }

    private int traverse(int[][] mat, int idx, int target) {
        if (idx == mat.length) {
            res = Math.abs(target);
            return res;
        }
        if (target >= 0 && memo[idx][target] != -1) {
            return memo[idx][target];
        }
        int res = Integer.MAX_VALUE;
        int n = mat[idx].length;
        for (int j = 0; j < n; j++) {
            if (j > 0 && mat[idx][j - 1] >= target) { // 剪枝，如果此时已经上一个遍历的数已经 >= target 了，那么就没有必要遍历接下来的数了
                break;
            }
            int t = traverse(mat, idx + 1, target - mat[idx][j]);
            res = Math.min(res, t);
        }
        if (target >= 0) {
            memo[idx][target] = res;
        }
        return res;
    }
}
