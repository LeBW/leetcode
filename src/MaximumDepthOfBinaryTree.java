/**
 * 104. Maximum Depth of Binary Tree
 * 二叉树的最大深度。递归即可。
 * @author LBW
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
