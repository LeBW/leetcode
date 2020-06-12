/**
 * 110. Balanced Binary Tree
 * @author LBW
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    /**
     * 后序遍历。
     * 当是平衡树的时候，返回height；否则返回-1。
     */
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int h1 = dfs(root.left);
        int h2 = dfs(root.right);
        if (h1 == -1 || h2 == -1 || Math.abs(h1 - h2) > 1)
            return -1;
        else
            return 1 + Math.max(h1, h2);
    }
}
