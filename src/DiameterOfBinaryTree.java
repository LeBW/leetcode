/**
 * 543. Diameter of Binary Tree
 * 二叉树的后序遍历
 * @author LBW
 */
public class DiameterOfBinaryTree {
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        postOrder(root);
        return res;
    }

    /**
     * post order travel
     * @return depth
     */
    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dleft = postOrder(root.left);
        int dright = postOrder(root.right);
        res = Math.max(res, dleft + dright);
        return Math.max(dleft, dright) + 1;
    }
}
