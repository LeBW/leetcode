package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LBW
 */
public class Baidu {
    public int[][] serialize(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        preOrder(root, preOrder);
        List<Integer> midOrder = new ArrayList<>();
        midOrder(root, midOrder);
        int n = preOrder.size();
        int[][] res = new int[2][n];
        for (int i = 0; i < n; i++) {
            res[0][i] = preOrder.get(i);
            res[1][i] = midOrder.get(i);
        }
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    private void midOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        midOrder(root.left, res);
        res.add(root.val);
        midOrder(root.right, res);
    }

    public TreeNode deserialize(int[][] arr) {
        int n = arr.length;
        TreeNode res = recover(arr[0], 0, n - 1, arr[1], 0, n - 1);
        return res;
    }

    private TreeNode recover(int[] preOrder, int ps, int pe, int[] midOrder, int ms, int me) {
        TreeNode root = new TreeNode(preOrder[ps]);
        int idx = ms;
        while (midOrder[idx] != preOrder[ps]) {
            idx += 1;
        }
        int numberOfLeft = idx - ms;
        root.left = recover(preOrder, ps + 1, ps + numberOfLeft, midOrder, ms, idx - 1);
        root.right = recover(preOrder, ps + numberOfLeft + 1, pe, midOrder, idx + 1, me);
        return root;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}