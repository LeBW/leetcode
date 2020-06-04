/**
 * 99. Recover Binary Search Tree
 *
 * 1. 二叉搜索树，中序遍历就是有序数组。
 * 2. 一个「交换了两个元素」的有序数组，是有模版在 O(n) 时间内找出被交换的元素x和y。
 * - 第一次遇到cur<prev时，确定x；第二次遇到时，确定y。
 *
 * @author LBW
 */
public class RecoverBinarySearchTree {
    private TreeNode prev;   // prev represents the last accessed treenode.
    private TreeNode x = null, y = null;   // x and y represent two elements

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);  // find x and y in the traversal.
        swap(x, y);  // swap x and y.
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);

        //find the two swapped elements: x and y.
        if ((prev != null) && (root.val < prev.val)) {
            y = root;
            if (x == null)
                x = prev;
            else
                return;
        }
        prev = root;
        inOrderTraversal(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
