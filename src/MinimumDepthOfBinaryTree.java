import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 111. Minimum Depth of Binary Tree
 * @author LBW
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class MinimumDepthOfBinaryTree {
    //递归DFS解法
    private int result = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        result = Integer.MAX_VALUE;
        dfs(root, 1);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            result = Math.min(result, depth);
        }
        if (root.left != null)
            dfs(root.left, depth+1);
        if (root.right != null)
            dfs(root.right, depth+1);
    }


    //层序遍历解法
    public int minDepthTwo(TreeNode root) {
        //recursion version
//        if (root == null)
//            return 0;
//        else if (root.left != null && root.right != null) {
//            return 1 + min(run(root.left), run(root.right));
//        }
//        else {
//            return 1 + max(run(root.left), run(root.right));
//        }
        if (root == null)
            return 0;
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(root);
        int depth = 0;
        //层序遍历
        while (!arrayList.isEmpty()) {
            depth += 1;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).left == null && arrayList.get(i).right == null)
                    return depth;
                if (arrayList.get(i).left != null)
                    arrayList.add(arrayList.get(i).left);
                if (arrayList.get(i).right != null)
                    arrayList.add(arrayList.get(i).right);
            }
            for (int i = 0; i < size; i++)
                arrayList.remove(0);
        }
        return depth;
    }


}
