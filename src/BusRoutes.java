import java.util.*;

/**
 * 815. Bus Routes
 * BFS
 * @author LBW
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        List<Set<Integer>> stations = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int m = routes.length;
        for (int i = 0; i < m ; i++) {
            stations.add(new HashSet<>());
            for (int j = 0; j < routes[i].length; j++) {
                stations.get(i).add(routes[i][j]);
            }
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (interact(stations.get(i), stations.get(j))) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] hasVisited = new boolean[m];
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> targets = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (stations.get(i).contains(target)) {
                targets.add(i);
            }
        }
        int cur = 1;
        for (int i = 0; i < m; i++) {
            if (stations.get(i).contains(source)) {
                if (targets.contains(i)) {
                    return cur;
                }
                queue.offer(i);
                hasVisited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            cur += 1;
            for (int i = 0; i < size; i++) {
                int bus = queue.poll();
                for (int next: graph.get(bus)) {
                    if (targets.contains(next))
                        return cur;
                    if (!hasVisited[next]) {
                        queue.offer(next);
                        hasVisited[next] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean interact(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return !result.isEmpty();
    }
}
