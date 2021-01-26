import java.util.Arrays;

/**
 * 1128. Number of Equivalent Domino Pairs
 * 解法一：并查集。需要先排序，复杂度O(nlogn)。
 * 解法二：哈希。时间复杂度 O(n).
 * @author LBW
 */
public class NumberOfEquivalentDominoPairs {
    // 解法一
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        for (int i = 0; i < n; i++) {
            if (dominoes[i][0] > dominoes[i][1]) {
                int tmp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = tmp;
            }
        }
        Arrays.sort(dominoes, (o1, o2) -> (o1[0] * 10 + o1[1] - o2[0] * 10 - o2[1]));
        DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n - 1; i++) {
            if (dominoes[i][0] == dominoes[i+1][0] && dominoes[i][1] == dominoes[i+1][1]) {
                disjointSet.union(i, i+1);
            }
        }
        return disjointSet.getResult();
    }

    static class DisjointSet {
        int[] parent;
        int[] size;
        int n;

        public DisjointSet(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
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
                size[pi] += size[pj];
            }
        }

        public int getResult() {
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] == i) {
                    res += size[i] * (size[i] - 1) / 2;
                }
            }
            return res;
        }
    }

    // 解法二
    public int numEquivDominoPairsTwo(int[][] dominoes) {
        int[] hash = new int[100];
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] > dominoes[i][1]) {
                int tmp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = tmp;
            }
            hash[dominoes[i][0] * 10 + dominoes[i][1]] += 1;
        }
        int res = 0;
        for (int i = 0; i < 100; i++) {
            if (hash[i] > 1) {
                res += hash[i] * (hash[i] - 1) / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfEquivalentDominoPairs numberOfEquivalentDominoPairs = new NumberOfEquivalentDominoPairs();
        numberOfEquivalentDominoPairs.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2},{1, 1}, {1, 2}, {2, 2}});
    }
}
