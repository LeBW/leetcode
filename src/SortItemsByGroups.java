import java.security.acl.Group;
import java.util.*;

/**
 * 1203. Sort items by Group Respecting Dependencies
 * 双层拓扑排序。困难
 * @author LBW
 */
public class SortItemsByGroups {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int nextGroupId = m;  // 将 -1 都换成新的单独的组，同时 nextGroup也可以表示组的数量.
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = nextGroupId++;
            }
        }
        List<List<Integer>> groupItems = new ArrayList<>();  // 用来存组内的节点
        List<List<Integer>> groupGraph = new ArrayList<>();  // 邻接表，用来存组与组之间的依赖关系
        int[] groupIndegree = new int[nextGroupId];
        List<List<Integer>> itemGraph = new ArrayList<>(); // 邻接表，用来存节点与节点之间的依赖关系
        int[] itemIndegree = new int[n];
        for (int i = 0; i < nextGroupId; i++) {
            groupItems.add(new ArrayList<>());
            groupGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }
        // 为 groupItems 添加元素
        for (int i = 0; i < n; i++) {
            groupItems.get(group[i]).add(i);
        }
        // 为 groupGraph 和 itemGraph 添加边和入度关系
        for (int i = 0; i < n; i++) {
            List<Integer> beforeItem = beforeItems.get(i);
            for (int before: beforeItem) {
                if (group[before] != group[i]) {  // 组间边
                    groupGraph.get(group[before]).add(group[i]);
                    groupIndegree[group[i]] += 1;
                }
                else {   // 组内边
                    itemGraph.get(before).add(i);
                    itemIndegree[i] += 1;
                }

            }
        }
        // 对组进行拓扑排序
        List<Integer> groupIdx = new ArrayList<>();  // 表示组的索引（用于拓扑排序）
        for (int i = 0; i < nextGroupId; i++) {
            groupIdx.add(i);
        }
        List<Integer> groupSortRes = topoSort(groupGraph, groupIndegree, groupIdx);
        if (groupSortRes == null) {
            return new int[]{};
        }
        // 对组内进行排序，取得结果
        int[] res = new int[n];
        int idx = 0;
        for (int groupId: groupSortRes) {
            List<Integer> items = groupItems.get(groupId);
            List<Integer> itemSortRes = topoSort(itemGraph, itemIndegree, items);
            if (itemSortRes == null) {
                return new int[]{};
            }
            while (!itemSortRes.isEmpty()) {
                res[idx++] = itemSortRes.get(0);
                itemSortRes.remove(0);
            }
        }
        return res;
    }

    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree, List<Integer> items) {
        int n = items.size();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int item: items) {
            if (indegree[item] == 0) {
                queue.offer(item);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (int node: graph.get(cur)) {
                indegree[node] -= 1;
                if (indegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        return res.size() == n ? res : null;
    }

    public static void main(String[] args) {
        SortItemsByGroups sortItemsByGroups = new SortItemsByGroups();
        int[] group = new int[]{2, 0, -1, 3, 0};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(Arrays.asList(2, 1, 3));
        beforeItems.add(Arrays.asList(2, 4));
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());

        sortItemsByGroups.sortItems(5, 5, group, beforeItems);
    }
}
