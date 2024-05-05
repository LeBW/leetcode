package algorithm.graph;

import java.util.*;

/**
 * 最短路径，Dijkstra 算法
 * 这里使用了邻接表的存储办法。
 * 并且，利用优先队列加快速度。由于使用的是普通的优先级队列（没有索引优先队列），所以没法判断队列中是否存在某元素，所以在放松的时候，只有重复添加元素
 * @author LBW
 */
public class ShortestDistance {
    private int[] distTo;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;

    private int V;
    private List<List<Node>> adj;
    private int src;

    public ShortestDistance(int V, List<List<Node>> adj, int src) {
        this.V = V;
        this.adj = adj;
        this.src = src;

        distTo = new int[V];
        settled = new HashSet<>();
        pq = new PriorityQueue<>(V, new Node());

        dijkstra();
    }

    private void dijkstra() {
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[src] = 0;

        pq.add(new Node(src, 0));

        while (settled.size() < V) { // 这里没有使用 !pq.isEmpty()，因为下文会重复添加相同的节点（不同的cost），所以不能通过队列为空来判断结束
            Node node = pq.poll();
            if (!settled.contains(node.node)) {  // 这里在从队列中取出 node 后，需要判断下 node.node 是否已经计算好，这同样也是因为队列中可能会有相同的节点（不同的cost）
                settled.add(node.node);
                distTo[node.node] = node.cost;
                for (Node next: adj.get(node.node)) {
                    if (distTo[next.node] > distTo[node.node] + next.cost) { // relax
                        distTo[next.node] = distTo[node.node] + next.cost;
                        pq.add(new Node(next.node, distTo[next.node]));  // 这里是直接添加元素，因为这是普通的优先级队列，没法判断队列中是否有没有某元素；如果使用更高级的数据结构（索引优先队列），会更容易理解。
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            graph.add(item);
        }
        graph.get(0).add(new Node(1, 9));
        graph.get(0).add(new Node(2, 6));
        graph.get(0).add(new Node(3, 5));
        graph.get(0).add(new Node(4, 3));

        graph.get(2).add(new Node(1, 2));
        graph.get(2).add(new Node(3, 4));

        ShortestDistance shortestDistance = new ShortestDistance(V, graph, source);
        System.out.println("Result: ");
        for (int i = 0; i < V; i++) {
            System.out.println(source + " to " + i + " is " + shortestDistance.distTo[i]);
        }
    }
}

class Node implements Comparator<Node> {
    int node;
    int cost;

    public Node() {}

    public Node (int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.cost - o2.cost;
    }
}
