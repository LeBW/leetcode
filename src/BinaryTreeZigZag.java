import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * BFS
 * @author LBW
 */
public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        List<List<Integer>> result =  new ArrayList<>();
        boolean seq = true;  // first, left to right
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.get(size - i - 1);
                queue.remove(size - i - 1);
                if (seq) {
                    if (cur.left != null)
                        queue.add(cur.left);
                    if (cur.right != null)
                        queue.add(cur.right);
                }
                else {
                    if (cur.right != null)
                        queue.add(cur.right);
                    if (cur.left != null)
                        queue.add(cur.left);
                }
                l.add(cur.val);
            }
            result.add(l);
            seq = !seq;
        }
        return result;
    }
}
