import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 * 树形动态规划。
 * 记忆化递归
 * @author LBW
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    private int robInternal(TreeNode root, Map<TreeNode, Integer> memo) {
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        if (root == null)
            return 0;
        // compare two results
        int result_1 = robInternal(root.left, memo) + robInternal(root.right, memo);
        int result_2 = root.val;
        if (root.left != null) {
            result_2 += robInternal(root.left.left, memo) + robInternal(root.left.right, memo);
        }
        if (root.right != null) {
            result_2 += robInternal(root.right.left, memo) + robInternal(root.right.right, memo);
        }
        int result = Math.max(result_1, result_2);
        memo.put(root, result);
        return result;
    }
}
