/**
 * 222. Count Complete Tree Nodes
 * 方法一：深度优先搜索。
 * 方法二：利用完全二叉树的性质（待实现）
 * @author LBW
 */
public class CountCompleteTreeNodes {
    /**
     * 判断左子树和右子树的高度。如果高度相同，说明左子树是满的；如果高度不同，说明右子树是满的。
     */
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = countDepth(root.left);
        int right = countDepth(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << (left+1));
        }
        else {
            return countNodes(root.left) + (1 << (right+1));
        }
    }

    private int countDepth(TreeNode root) {
        if (root == null)
            return -1;
        int result = 0;
        root = root.left;
        while (root != null) {
            root = root.left;
            result += 1;
        }
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + dfs(root.left) + dfs(root.right);
    }
}
