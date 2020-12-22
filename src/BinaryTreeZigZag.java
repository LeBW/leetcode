import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * BFS
 * @author LBW
 */
public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        boolean inOrder = false;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            // add list to res
            List<Integer> list = new ArrayList<>();
            if (inOrder) {
                for (int i = size - 1; i >= 0; i--) {
                    list.add(queue.get(i).val);
                }
            }
            else {
                for (int i = 0; i < size; i++) {
                    list.add(queue.get(i).val);
                }
            }
            res.add(list);
            // add next level
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.get(0);
                queue.remove(0);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            //reverse Order
            inOrder = !inOrder;
        }
        return res;
    }
}
