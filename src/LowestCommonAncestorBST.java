/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 递归，要利用BST的性质，就比236简单。
 * 时间复杂度O(logn)
 * @author LBW
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}
