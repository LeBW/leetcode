package lcof;

/**
 * Offer 68-II. 二叉树的最近公共祖先
 * 既不是完全的先序遍历，也不是完全的后序遍历。
 * 前面部分是先序遍历，碰到了底或者p或者q，就返回向上回溯。
 * 后面部分像是后序遍历，在遍历之后判断左右返回的情况，从而决定如何返回
 * @author LBW
 */
public class Offer68II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {  // 说明公共节点在右子树中
            return right;
        }
        else if (right == null) {  // 说明公共节点在左子树中
            return left;
        }
        return root;  // 说明公共节点在当前节点的两边
    }
}
