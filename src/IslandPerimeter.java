/**
 * 463. Island Perimeter
 * @author LBW
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return 1;  // 遇到边界，周长+1
        if (grid[i][j] == 0)
            return 1;  // 遇到水，周长+1
        if (grid[i][j] == 2)
            return 0;  // 已经访问过的顶点，周长不加

        grid[i][j] = 2; // marks that it has been visited.
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
