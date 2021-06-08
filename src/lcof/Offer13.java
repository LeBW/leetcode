package lcof;

/**
 * Offer13. 机器人的运动范围
 * DFS
 * @author LBW
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        return dfs(isVisited, m, n, k, 0, 0);
    }

    private int dfs(boolean[][] isVisited, int m, int n, int k, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || isVisited[i][j] || check(i, j, k)) {
            return 0;
        }
        isVisited[i][j] = true;
        return 1 + dfs(isVisited, m, n, k, i - 1, j) + dfs(isVisited, m, n, k, i + 1, j) + dfs(isVisited, m, n, k, i, j - 1) + dfs(isVisited, m, n, k, i, j + 1);

    }

    private boolean check(int i, int j, int k) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum > k;
    }
}
