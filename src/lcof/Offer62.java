package lcof;

/**
 * Offer 62. 圆圈中最后剩下的数字
 * 约瑟夫环问题，需要用动态规划在 O(n) 时间解决。
 * 假设 n 个数，从第 m 个开始删除，那么最后剩下的数是 f(n, m)
 * 主要是需要理解状态转移方程：
 * f(n, m) = (f(n - 1, m) + m) % n
 * @author LBW
 */
public class Offer62 {
    /*
    动态规划解法
     */
    public int lastRemainingTwo(int n, int m) {
        int[] dp = new int[n + 1];
        dp[1] = 0; // 只有一个元素时，一定是 0
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + m) % i;
        }
        return dp[n];
    }

    /*
    我的方法，使用模拟解决，时间复杂度 O（mn）
    当 m 和 n 很大时，会超时
     */
    public int lastRemaining(int n, int m) {
        if (m == 1) {   // 当 m 为 1 时，需要特殊处理
            return n - 1;
        }
        Node head = buildList(n);
        Node cur = head;
        for (int i = 0; i < n - 1; i++) {
            Node pre = null;
            for (int k = 0; k < m - 1; k++) {
                pre = cur;
                cur = cur.next;
            }
            Node next = cur.next;
            pre.next = cur.next;
            cur = next;
        }
        return cur.val;
    }

    private Node buildList(int n) {
        Node head = new Node(0);
        Node tail = head;
        for (int i = 1; i < n; i++) {
            Node t = new Node(i);
            tail.next = t;
            tail = tail.next;
        }
        tail.next = head; // 创建循环
        return head;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


}
