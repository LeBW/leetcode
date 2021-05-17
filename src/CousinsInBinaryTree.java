import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tree
 * BFS
 * @author LBW
 */
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int depth = 0, dx = 0, dy = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) {
                    dx = depth;
                }
                if (cur.val == y) {
                    dy = depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null && cur.right != null && ((cur.left.val == x && cur.right.val == y) || (cur.left.val == y && cur.right.val == x))) {
                    return false;
                }
            }
            depth += 1;
        }
        return dx == dy;
    }
}
