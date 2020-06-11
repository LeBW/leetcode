import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * 头部插入
 * @author LBW
 */
public class BinaryTreeLevelOrderII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                l.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            result.add(0, l);
        }
        return result;
    }
}
