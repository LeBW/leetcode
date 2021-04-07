package interview;

import java.util.*;

public class MainTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] edges = new String[N];
        for (int i = 0; i < N; i++) {
            edges[i] = scanner.nextLine();
        }
        Map<String, Integer> map = new HashMap<>(); // String to index
        int index = 0;
        DisjointSet disjointSet = new DisjointSet(N);
        for (String edge: edges) {
            //System.out.println(edge);
            String[] strs = edge.split(" ");
            if (!map.containsKey(strs[0])) {
                map.put(strs[0], index++);
            }
            if (!map.containsKey(strs[1])) {
                map.put(strs[1], index++);
            }
            disjointSet.union(map.get(strs[0]), map.get(strs[1]));
        }
        System.out.println(disjointSet.getSize());
    }
}

class DisjointSet {
    private int N;
    private int size;
    private int[] parent;

    public DisjointSet(int N) {
        this.N = N;
        this.size = N;
        this.parent = new int[N];
        for (int i = 0 ;i < N; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int pi = find(i), pj = find(j);
        if (pi != pj) {
            parent[pi] = pj;
            size -= 1;
        }
    }

    public int getSize() {
        return size;
    }

}