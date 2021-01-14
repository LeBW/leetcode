import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. Course Schedule II.
 * 拓扑排序（利用BFS）
 * @author LBW
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseGraph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseGraph.add(new ArrayList<>());
        }
        int[] courseInDegree = new int[numCourses];
        for (int[] pre: prerequisites) {
            courseGraph.get(pre[1]).add(pre[0]);
            courseInDegree[pre[0]] += 1;
        }
        // topo sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (courseInDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ans[idx++] = course;
            for (int next: courseGraph.get(course)) {
                courseInDegree[next] -= 1;
                if (courseInDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (idx == numCourses) {
            return ans;
        }
        return new int[]{};
    }
}
