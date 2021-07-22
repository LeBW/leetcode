package lcof;

/**
 * Offer 55-II. 平衡二叉树
 * 判断是否是平衡二叉树，因为要判断任意节点的左右子树深度相差不超过 1，所以更适合自底向上进行判断，一旦遇到不平衡的，就返回 -1，否则返回其高度。
 *
 * 总结来说就是一个变式的后序遍历：
 * 1. 左右子树均满足平衡二叉树，并且自身也满足时，返回自身的高度。
 * 2. 左右子树不满足平衡二叉树，或者自身不满足时，返回 -1。
 * @author LBW
 */
public class Offer55II {
    public boolean isBalanced(TreeNode root) {
        return postOrder(root) != -1;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h1 = postOrder(root.left);
        if (h1 == -1) {
            return -1;
        }
        int h2 = postOrder(root.right);
        if (h2 == -1 || Math.abs(h1 - h2) > 1) {
            return -1;
        }
        return Math.max(h1, h2) + 1;
    }
}
