import java.util.Arrays;

/**
 * 684. Redundant Connection
 * 用并查集判断图有没有环
 * @author LBW
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge: edges) {
            if (!disjointSet.union(edge[0], edge[1])) {  // 说明有环
                return edge;
            }
        }
        return new int[]{-1, -1};
    }

    static class DisjointSet {
        private int[] parent;
        private int[] rank;
        private int n;

        public DisjointSet(int n) {
            this.n = n;
            parent = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            rank = new int[n+1];
            Arrays.fill(rank, 1);
        }

        public int find(int k) {
            if (parent[k] != k) {
                parent[k] = find(parent[k]);
            }
            return parent[k];
        }

        public boolean union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj)
                return false;
            if (rank[pi] < rank[pj]) {
                int tmp = pi;
                pi = pj;
                pj = tmp;
            }
            parent[pj] = pi;
            rank[pi] += rank[pj];
            return true;
        }
    }
}

