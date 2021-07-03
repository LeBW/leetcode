package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer34. 二叉树中和为某一值的路径
 * @author LBW
 */
public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(root, target, cur, res);
        return res;
    }

    private void dfs(TreeNode node, int target, List<Integer> cur, List<List<Integer>> res) {
        cur.add(node.val);
        target = target - node.val;
        if (node.left == null && node.right == null && target == 0) {
            res.add(new ArrayList<>(cur));
        }
        else {
            if (node.left != null) {
                dfs(node.left, target, cur, res);
            }
            if (node.right != null) {
                dfs(node.right, target, cur, res);
            }
        }
        cur.remove(cur.size() - 1);

    }
}
