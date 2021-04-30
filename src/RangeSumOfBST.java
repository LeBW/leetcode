/**
 * 938. Range Sum of BST
 *
 * @author LBW
 */
public class RangeSumOfBST {
    private int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        traverse(root, low, high);
        return result;
    }

    private void traverse(TreeNode node, int low, int high) {
        if (node == null)
            return;
        traverse(node.left, low, high);
        if (node.val >= low && node.val <= high) {
            result += node.val;
        }
        traverse(node.right, low, high);
    }
}
