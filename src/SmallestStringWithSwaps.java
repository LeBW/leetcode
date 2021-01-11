import java.util.*;

/**
 * 1202. Smallest String with Swaps
 * 本题主要是使用并查集对节点进行分类，然后对连通分量内的字母进行排序后输出到相应的位置即可。
 * **路径压缩**的**加权**并查集算法：<br>
 * 1. 路径压缩：在find()的时候，将每一层的节点直接指向根节点（使树尽量扁平化）
 * 2. 加权：在union()的时候，永远考虑将小树加到大树上（而不是将大树加到小树上）
 * @author LBW
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DisjointSet disjointSet = new DisjointSet(n);
        for (List<Integer> pair: pairs) {
            disjointSet.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = disjointSet.find(i);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s.charAt(i));
        }
        for (Map.Entry<Integer, List<Character>> entry: map.entrySet()) {
            entry.getValue().sort(((o1, o2) -> o2 - o1));
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            List<Character> list = map.get(disjointSet.find(i));
            res.append(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps smallestStringWithSwaps = new SmallestStringWithSwaps();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0, 3));
        list.add(Arrays.asList(1, 2));
        smallestStringWithSwaps.smallestStringWithSwaps("dcab", list);
    }
}

class DisjointSet {
    private int n;
    private int[] parent;  // 记录节点的父链接
    int[] size;  // 记录节点所在分量的大小

    public DisjointSet(int n) {
        this.n = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
        this.size = new int[n];
        Arrays.fill(size, 1);
    }

    public int find(int i) {
        if (parent[i] == i)
            return i;
        else {
            parent[i] = find(parent[i]);  // 路径压缩
            return parent[i];
        }
    }

    public void union(int i, int j) {
        int pi = find(i), pj = find(j);
        if (pi == pj)
            return;
        if (size[pi] < size[pj]) { // 加权。将小树添加到大树上
            int tmp = pi;
            pi = pj;
            pj = tmp;
        }
        parent[pj] = pi;
        size[pi] += size[pj];
    }
}