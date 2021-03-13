package interview;

/**
 * @author LBW
 */
import java.util.*;
public class Two {
    final static int N = 100000;
    static ArrayList<Integer>[] graph = new ArrayList[N + 1];
    static int visited[] = new int[N + 1];

    public static void main(String[] args) {
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int ans = 0;
            for (int i = 0; i <= n; i++) {
                graph[i].clear();
                visited[i] = 0;
            }
            for (int i = 1; i <= m; i++) {
                int x = scanner.nextInt(), y = scanner.nextInt();
                if (x == y)
                    continue;
                graph[x].add(y);
                graph[y].add(x);
                ans++;
            }
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    int k = traverse(i, 0);
                    ans += k;
                }
            }
            System.out.println(ans);
        }
    }

    private static int traverse(int x, int i1) {
        visited[x] = 1;
        for (int i = 0; i < graph[i].size(); i++) {
            if (graph[x].get(i) == i1)
                continue;
            if (visited[graph[x].get(i)] == 1)
                return 1;
            traverse(graph[x].get(i), x);
        }
        return 0;
    }
}
