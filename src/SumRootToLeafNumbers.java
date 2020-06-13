/**
 * 129. Sum Root to Leaf Numbers
 * @author LBW
 */
public class SumRootToLeafNumbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        preOrderTraversal(root, 0);
        return sum;
    }

    private void preOrderTraversal(TreeNode root, int cur) {
        if (root == null)
            return;
        int t = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += t;
        }
        preOrderTraversal(root.left, t);
        preOrderTraversal(root.right, t);
    }
}
