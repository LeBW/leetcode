/**
 * 1219. Path with Maximum Gold
 * 回溯
 * @author LBW
 */
public class PathWithMaximumGold {
    private int max = Integer.MIN_VALUE;

    public int getMaximumGold(int[][] grid) {
        int l = grid.length, c = grid[0].length;
        boolean[][] isVisited = new boolean[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] > 0) {
                    dfs(grid, 0, isVisited, i, j);
                    //backTrack
                    isVisited[i][j] = false;
                }
            }
        }
        return max;
    }

    private boolean isValid(int[][] grid, boolean[][] isVisited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || isVisited[i][j])
            return false;
        else
            return true;
    }

    private void dfs(int[][] grid, int cur, boolean[][] isVisited, int i, int j) {
        cur += grid[i][j];
        isVisited[i][j] = true;
        if (cur > max)
            max = cur;
        if (isValid(grid, isVisited, i - 1, j)) {
            dfs(grid, cur, isVisited, i - 1, j);
            //backtrack
            isVisited[i-1][j] = false;
        }
        if (isValid(grid, isVisited, i + 1, j)) {
            dfs(grid, cur, isVisited, i + 1, j);
            isVisited[i+1][j] = false;
        }
        if (isValid(grid, isVisited, i, j + 1)) {
            dfs(grid, cur, isVisited, i, j + 1);
            isVisited[i][j + 1] = false;
        }
        if (isValid(grid, isVisited, i, j - 1)) {
            dfs(grid, cur, isVisited, i, j - 1);
            isVisited[i][j - 1] = false;
        }
    }
}
