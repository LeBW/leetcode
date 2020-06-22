/**
 * 222. Count Complete Tree Nodes
 * 方法一：深度优先搜索。
 * 方法二：利用完全二叉树的性质（待实现）
 * @author LBW
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + dfs(root.left) + dfs(root.right);
    }
}
