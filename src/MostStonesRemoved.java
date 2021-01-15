import java.util.Arrays;

/**
 * 947. Most Stones Removed with Same Row or Column
 * @author LBW
 */
public class MostStonesRemoved {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSet set = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    set.union(i, j);
                }
            }
        }
        return n - set.getSize();
    }

    static class DisjointSet {
        int size;
        int n;
        int[] parent;
        int[] rank;

        public DisjointSet(int n) {
            this.n = n;
            this.size = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.rank = new int[n];
            Arrays.fill(rank, 1);
        }

        public int find(int k) {
            if (parent[k] != k) {
                parent[k] = find(parent[k]);
            }
            return parent[k];
        }

        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj)
                return;
            if (rank[pi] < rank[pj]) {
                int tmp = pj;
                pj = pi;
                pi = tmp;
            }
            parent[pj] = pi;
            rank[pi] += rank[pj];
            this.size -= 1;
        }

        public int getSize() {
            return size;
        }
    }
}
