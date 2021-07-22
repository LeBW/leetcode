package lcof;

/**
 * Offer 54. 二叉搜索树的第k大节点
 * 二叉搜索树的 反中序遍历 ：右中左
 * @author LBW
 */
public class Offer54 {
    private int curIdx = 0;
    private int res = 0;
    public int kthLargest(TreeNode root, int k) {
        reverseInOrder(root, k);
        return res;
    }

    private boolean reverseInOrder(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (reverseInOrder(root.right, k)) {
            return true;
        }
        curIdx += 1;
        if (curIdx == k) {
            res = root.val;
            return true;
        }
        return reverseInOrder(root.left, k);
    }
}
