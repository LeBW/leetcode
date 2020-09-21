/**
 * 538. Convert BST to Greater Tree
 * @author LBW
 */
public class ConvertBSTtoGreaterTree {
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        reverseTraversal(root);
        return root;
    }

    /*
    反中序遍历
     */
    private void reverseTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        reverseTraversal(root.right);
        sum += root.val;
        root.val = sum;
        reverseTraversal(root.left);
    }
}
