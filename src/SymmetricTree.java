/**
 * 101. Symmetric Tree
 * 递归解法，解决对称二叉树的问题。
 * 关键在于：如何找到子问题结构。也就是说，如何判断两个树是对称的
 * @author LBW
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
