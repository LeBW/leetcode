/**
 * 547. Number of Provinces
 * DFS 计算连通分量
 * @author LBW
 */
public class NumberOfProvince {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, isConnected, isVisited);
                res += 1;
            }
        }
        return res;
    }

    private void dfs(int node, int[][] isConnected, boolean[] isVisited) {
        isVisited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !isVisited[i]) {
                dfs(i, isConnected, isVisited);
            }
        }
    }
}
