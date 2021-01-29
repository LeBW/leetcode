import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1631. Path With Minimum Effort
 * Dijkstra算法的修改版
 * 最短路径不是加法求和，而是求最大值
 * @author LBW
 */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        Position[][] pos = new Position[r][c];
        boolean[][] isVisited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                pos[i][j] = new Position(i, j, Integer.MAX_VALUE);
            }
        }
        pos[0][0].val = 0;
        PriorityQueue<Position> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                queue.offer(pos[i][j]);
            }
        }
        while (!isVisited[r-1][c-1]) {
            Position cur = queue.poll();
            isVisited[cur.x][cur.y] = true;
            if (cur.x + 1 < r && !isVisited[cur.x+1][cur.y]) {
                int curMin = Math.max(cur.val, Math.abs(heights[cur.x+1][cur.y] - heights[cur.x][cur.y]));
                if (curMin < pos[cur.x+1][cur.y].val) {
                    queue.remove(pos[cur.x+1][cur.y]);
                    pos[cur.x+1][cur.y].val = curMin;
                    queue.offer(pos[cur.x+1][cur.y]);
                }
            }
            if (cur.x - 1 >= 0 && !isVisited[cur.x-1][cur.y]) {
                int curMin = Math.max(cur.val, Math.abs(heights[cur.x-1][cur.y] - heights[cur.x][cur.y]));
                if (curMin < pos[cur.x-1][cur.y].val) {
                    queue.remove(pos[cur.x-1][cur.y]);
                    pos[cur.x-1][cur.y].val = curMin;
                    queue.offer(pos[cur.x-1][cur.y]);
                }
            }
            if (cur.y + 1 < c && !isVisited[cur.x][cur.y+1]) {
                int curMin = Math.max(cur.val, Math.abs(heights[cur.x][cur.y+1] - heights[cur.x][cur.y]));
                if (curMin < pos[cur.x][cur.y+1].val) {
                    queue.remove(pos[cur.x][cur.y+1]);
                    pos[cur.x][cur.y+1].val = curMin;
                    queue.offer(pos[cur.x][cur.y+1]);
                }
            }
            if (cur.y - 1 >= 0 && !isVisited[cur.x][cur.y-1]) {
                int curMin = Math.max(cur.val, Math.abs(heights[cur.x][cur.y-1] - heights[cur.x][cur.y]));
                if (curMin < pos[cur.x][cur.y-1].val) {
                    queue.remove(pos[cur.x][cur.y-1]);
                    pos[cur.x][cur.y-1].val = curMin;
                    queue.offer(pos[cur.x][cur.y-1]);
                }
            }
        }
        return pos[r-1][c-1].val;
    }
    static class Position {
        int x;
        int y;
        int val;
        public Position(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
        int[][] heights = new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1}, {1,2,1,2,1}, {1,1,1,2,1}};
        System.out.println(pathWithMinimumEffort.minimumEffortPath(heights));
    }

}
