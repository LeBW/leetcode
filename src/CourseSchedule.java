import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule
 * 拓扑排序：依次找出入度为0的节点出图，并更新其相邻节点的入度（利用队列）。
 * @author LBW
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(); // 用邻接表表示图
        int[] inCount = new int[numCourses];  // 用一个数组表示节点的入度
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inCount[prerequisites[i][0]] += 1;
        }
        // 用 BFS 的思想进行拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inCount[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count += 1;
            for (int i: adj.get(node)) {
                inCount[i] -= 1;
                if (inCount[i] == 0)
                    queue.offer(i);
            }
        }
        return count == numCourses;
    }
}
