import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 310. Minimum Height Trees
 * 我想到的方法：对所有节点进行BFS求高度，然后找最小高度。结果超时。
 * 答案的方法：从最外层开始，类似层序遍历进行剥离。最后留下的一层就是答案。
 * @author LBW
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int[] heights = new int[n];
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // BFS to get height from i.
            int height = 0;
            Queue<Integer> queue = new LinkedList<>();
            boolean[] hasVisited = new boolean[n];
            queue.offer(i);
            hasVisited[i] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int cur = queue.poll();
                    hasVisited[cur] = true;
                    for (int next: graph.get(cur)) {
                        if (!hasVisited[next]) {
                            queue.offer(next);
                        }
                    }
                }
                height += 1;
            }
            heights[i] = height;
            if (height < minHeight)
                minHeight = height;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (heights[i] == minHeight)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        minimumHeightTrees.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
    }
}
