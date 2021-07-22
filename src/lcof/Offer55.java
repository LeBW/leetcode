package lcof;

/**
 * Offer 55. 二叉树的深度
 * @author LBW
 */
public class Offer55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
