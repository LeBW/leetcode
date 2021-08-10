package lcof;

/**
 * Offer 68. 二叉搜索树的最近公共祖先
 * 利用二叉搜索树的特性从根节点往下搜索，直到分叉为止
 * @author LBW
 */
public class Offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pval = p.val, qval = q.val;
        TreeNode cur = root;
        while ((cur.val < pval && cur.val < qval) || (cur.val > pval && cur.val > qval)) {
            if (cur.val < pval && cur.val < qval) {
                cur = cur.right;
            }
            else {
                cur = cur.left;
            }
        }
        return cur;
    }
}
