import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division
 * 图算法。
 * 用邻接表表示图，DFS求距离。
 * 注意在一般的邻接表里，顶点用数组表示，数组的索引0, 1, 2, ... 代表顶点。但是在本题目里顶点是字符串，因此我采用Map<String, List<EdgeNode>>的方法来表示邻接表
 * @author LBW
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        Map<String, List<EdgeNode>> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            if (!nodeMap.containsKey(s1)) {
                nodeMap.put(s1, new ArrayList<EdgeNode>());
            }
            if (!nodeMap.containsKey(s2)) {
                nodeMap.put(s2, new ArrayList<EdgeNode>());
            }
            // add edges
            nodeMap.get(s1).add(new EdgeNode(s2, values[i]));
            nodeMap.get(s2).add(new EdgeNode(s1, 1 / values[i]));
        }
        int v = nodeMap.size();
        double[] res = new double[queries.size()];
        //dfs to find queries
        for (int i = 0; i < queries.size(); i++) {
            double ans = -1.0;
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);
            if (!nodeMap.containsKey(s1) || !nodeMap.containsKey(s2)) {
                res[i] = -1.0;
                continue;
            }
            Map<String, Double> vals = new HashMap<>();
            vals.put(s1, 1.0);
            if (dfs(s1, nodeMap, vals, s2)) {
                ans = vals.get(s2);
            }
            res[i] = ans;
        }
        return res;
    }

    private boolean dfs(String s1, Map<String, List<EdgeNode>> nodeMap, Map<String, Double> vals, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        List<EdgeNode> edgeList = nodeMap.get(s1);
        for (EdgeNode edge: edgeList) {
            if (!vals.containsKey(edge.dest)) {
                vals.put(edge.dest, vals.get(s1) * edge.weight);
                if (dfs(edge.dest, nodeMap, vals, s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class EdgeNode {
        String dest;
        double weight;

        public EdgeNode(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
