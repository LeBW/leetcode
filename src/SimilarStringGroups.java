/**
 * 839. Similar String Groups
 * @author LBW
 */
public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    disjointSet.union(i, j);
                }
            }
        }
        return disjointSet.size;
    }

    private boolean isSimilar(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int len = s1.length();
        int[] notSameIdx = new int[2];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (idx > 1)
                    return false;
                notSameIdx[idx++] = i;
            }
        }
        if (idx == 2 && (s1.charAt(notSameIdx[0]) == s2.charAt(notSameIdx[1])) && (s1.charAt(notSameIdx[1]) == s2.charAt(notSameIdx[0])))
            return true;
        return false;
    }

    static class DisjointSet {
        int n;
        int[] parent;
        int size;

        public DisjointSet(int n) {
            this.n = n;
            parent = new int[n];
            size = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
        SimilarStringGroups similarStringGroups = new SimilarStringGroups();
        String[] strs = new String[]{"tars", "rats", "arts", "start"};
        System.out.println(similarStringGroups.numSimilarGroups(strs));
    }
}
