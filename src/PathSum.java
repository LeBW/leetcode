/**
 * 112. Path Sum
 * @author LBW
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int cur, int sum) {
        if (root == null)
            return false;
        cur = cur + root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        }
        return dfs(root.left, cur, sum) || dfs(root.right, cur, sum);
    }
}
