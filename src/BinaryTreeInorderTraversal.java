import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * @author LBW
 */

public class BinaryTreeInorderTraversal {
    /**
     * Method 1: Recursion. 递归解法. 较为简单
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            dfs(root.left, result);
            result.add(root.val);
            dfs(root.right, result);
        }
    }

    /**
     * Method 2: Iteration  迭代解法. 模拟递归调用栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalTwo(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {   // 循环条件：cur不为空 或者 栈不为空。 其中cur不为空的情况出现在：左节点和根节点都访问完毕时，当前指向根节点的右节点时，栈恰好为空，但是此时还未结束。
            if (cur != null) {   // 当cur不为空时，将cur加入栈中，并指向左节点.
                stack.push(cur);
                cur = cur.left;
            }
            else {              // 当cur为空时，从栈中弹出顶部元素，加入结果中，并将cur指向其右节点。
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = BinaryTreePostorderTraversal.getTreeA();
        System.out.println(binaryTreeInorderTraversal.inorderTraversalTwo(root));
    }
}
