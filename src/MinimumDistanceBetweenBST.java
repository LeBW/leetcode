/**
 * 783. Minimum Distance Between BST Nodes
 * 二叉搜索树，中序遍历
 * @author LBW
 */
public class MinimumDistanceBetweenBST {
    private int pre = -1;
    private int result = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        // in order traversal
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        if (pre != -1) {
            result = Math.min(result, Math.abs(root.val - pre));
        }
        pre = root.val;
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
