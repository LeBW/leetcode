/**
 * 226. Invert Binary Tree
 * 递归
 * @author LBW
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
