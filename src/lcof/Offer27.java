package lcof;

/**
 * Offer27. 二叉树的镜像
 * 递归
 * @author LBW
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = mirrorTree(root.right);
        newRoot.right = mirrorTree(root.left);
        return newRoot;
    }
}
