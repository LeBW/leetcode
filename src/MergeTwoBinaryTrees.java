/**
 * 617. Merge Two Binary Trees
 * 递归（深度优先搜索）
 * @author LBW
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // root1 != null && root2 != null
        TreeNode cur = new TreeNode(root1.val + root2.val);
        cur.left = mergeTrees(root1.left, root2.left);
        cur.right = mergeTrees(root1.right, root2.right);
        return cur;
    }
}
