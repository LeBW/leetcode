import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * @author LBW
 */
public class BinaryTreePreorderTraversal {
    /**
     * Method 1: Recursion. 递归解法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, ArrayList<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }

    /**
     * Method 2: Iteration. 迭代解法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalTwo(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);   // 先将根节点入栈
        while (!stack.isEmpty()) {    // 循环条件为：栈不为空
            TreeNode cur = stack.pop();  // 弹出当前节点
            if (cur != null) {   //当前节点不为空时，先添加值进入结果数组，然后分别压入右节点和左节点（先右后左）
                result.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return result;
    }

    /**
     * Method 3: Iteration 2：迭代解法2. 为了使前序遍历与中序遍历的形式相同，编写了一种类似的写法
     */
    public List<Integer> preorderTraversalThree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {  // 循环条件：cur不为空 或者 栈不为空。 其中cur不为空的情况出现在：左节点和根节点都访问完毕时，当前指向根节点的右节点时，栈恰好为空，但是此时还未结束。
            if (cur != null) {   //当cur不为空时，先输出其值，再将其压栈（为了后面能够进入其右节点），再访问它的左节点。
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            else {              //当cur为空时，弹栈。此时栈顶元素已经被访问且输出过，所以此次直接进入其右节点即可。
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }


}
