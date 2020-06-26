import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. Kth Smallest Element in a BST
 * 中序遍历，到第k个就停下来
 * @author LBW
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int i = 0;

        while(!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                i += 1;
                if (i == k)
                    return cur.val;
                cur = cur.right;
            }
        }
        return -1;
    }
}
