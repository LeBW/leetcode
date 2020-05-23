import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * 注意的是：为了循环体内每次只弹出某一层的元素，可以在开始的时候先记录下队列的长度。
 * @author LBW
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            TreeNode cur = null;
            for (int i = 0; i < len; i++) {
                cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            result.add(tmp);
        }
        return result;
    }
}
