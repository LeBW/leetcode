import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1584. Min Cost to Connect all Points
 * 最小生成树。这里使用 Kruskal 算法，对所有边做排序，然后每次选择最小的边，直至所有点连通。（使用并查集判断两点之间是否连通）
 * @author LBW
 */
public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Edge edge = new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                edges.add(edge);
            }
        }
        Collections.sort(edges, (o1, o2) -> (o1.distance - o2.distance));
        DisjointSet disjointSet = new DisjointSet(points.length);
        int edgeIdx = 0;
        int res = 0;
        while (disjointSet.size > 1) {
            Edge edge = edges.get(edgeIdx);
            if (disjointSet.find(edge.start) == disjointSet.find(edge.end)) {
                edgeIdx += 1;
                continue;
            }
            disjointSet.union(edge.start, edge.end);
            res += edge.distance;
            edgeIdx += 1;
        }
        return res;

    }

    static class Edge {
        int start;
        int end;
        int distance;

        public Edge (int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    static class DisjointSet {
        int n;
        int size;
        int[] parent;

        public DisjointSet(int n ) {
            this.n = n;
            this.size = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int k) {
            if (parent[k] != k) {
                parent[k] = find(parent[k]);
            }
            return parent[k];
        }

        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi != pj) {
                parent[pj] = pi;
                size -= 1;
            }
        }
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        minCostToConnectAllPoints.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});
    }
}
