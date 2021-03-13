package interview;

/**
 * @author LBW
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (!graph.get(start).contains(end)) {
                graph.get(start).add(end);
            }
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            // shortest path
            int result = shortestPath(graph, x, y);
            System.out.println(result);
        }
    }

    private static int shortestPath(List<List<Integer>> graph, int x, int y) {
        int dis = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] hasVisited = new boolean[graph.size()];
        queue.offer(x);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                hasVisited[cur] = true;
                if (cur == y)
                    return dis;
                for (int next: graph.get(cur)) {
                    if (!hasVisited[next])
                        queue.offer(next);
                }
            }
            dis += 1;
        }
        return -1;
    }
}
