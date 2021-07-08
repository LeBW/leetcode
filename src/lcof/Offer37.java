package lcof;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Offer 37. 序列化二叉树
 * @author LBW
 */
public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        int height = height(root);
        for (int h = 0; h < height; h++) {  // 这里用高度来判断循环，而不是 queue.isEmpty()，是因为要去掉最后一层全部都是 null 的情况。
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res.add(cur == null ? null : cur.val);
                if (cur != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        return listToString(res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> list = stringToList(data);
        if (list.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < list.size()) {
            TreeNode cur = queue.poll();
            if (list.get(i) != null) {
                cur.left = new TreeNode(list.get(i));
                queue.offer(cur.left);
            }
            if (i + 1 < list.size() && list.get(i + 1) != null) {
                cur.right = new TreeNode(list.get(i + 1));
                queue.offer(cur.right);
            }
            i += 2;
        }
        return root;
    }

    private List<Integer> stringToList(String data) {
        if (data.equals("[]")) {
            return new ArrayList<>();
        }
        String[] strs = data.substring(1, data.length() - 1).split(",");
        List<Integer> res = new ArrayList<>();
        for (String str: strs) {
            if (str.equals("null")) {
                res.add(null);
            }
            else {
                res.add(Integer.valueOf(str));
            }
        }
        return res;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private String listToString(List<Integer> res) {
        if (res.size() == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < res.size() - 1; i++) {
            builder.append(res.get(i));
            builder.append(",");
        }
        builder.append(res.get(res.size() - 1));
        builder.append("]");
        return builder.toString();
    }



    public static void main(String[] args) {
        Offer37 offer37 = new Offer37();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = offer37.serialize(root);
        System.out.println(str);
        System.out.println(offer37.deserialize(str));
    }
}
