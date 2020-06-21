import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * @author LBW
 */
public class BinaryTreeRightView {
    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        preOrderTraversal(root, 0);
        return result;
    }

    private void preOrderTraversal(TreeNode root, int height) {
        if (root == null)
            return;
        if (result.size() <= height) {
            result.add(root.val);
        }
        else {
            result.set(height, root.val);
        }
        preOrderTraversal(root.left, height + 1);
        preOrderTraversal(root.right, height + 1);
    }
}
