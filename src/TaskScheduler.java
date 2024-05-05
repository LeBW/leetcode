import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 621. Task Scheduler
 * 数学思想，总体思想是：
 * 1. 先找出最多的任务执行次数 maxExec，和是该执行次数的任务数量 maxCount.
 * 2. 当需要有空闲时间时，可以用 (maxExec - 1) * (n + 1) + maxCount 计算总用时。
 * 3. 当不需要空间时间（也就是任务数量很多）时，总用时直接就是 tasks.length
 * 4. 取上面两值的最大值即可。
 * @author LBW
 */
public class TaskScheduler {
    /**
     * 方法一，模拟
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] count = new int[26];
        for (char task: tasks) {
            count[task - 'A'] += 1;
        }
        Set<Integer> cooldown = new HashSet<>();
        List<Integer> units = new ArrayList<>();
        int done = 0;
        while (done < tasks.length) {
            int cur = findCur(count, cooldown);
            if (cur != -1) {
                done += 1;
                count[cur] -= 1;
                cooldown.add(cur);
            }
            if (units.size() - n >= 0 && units.get(units.size() - n) != -1) {
                cooldown.remove(units.get(units.size() - n));
            }
            units.add(cur);

        }
        return units.size();
    }

    private int findCur(int[] count, Set<Integer> cooldown) {
        int max = 0, res = -1;
        for (int i = 0; i < 26; i++) {
            if (!cooldown.contains(i) && count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }

    /**
     * 方法二，数学分析，非常巧妙
     * @param tasks
     * @param n
     * @return
     */
    public int leastIntervalTwo(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] count = new int[26];
        int maxExec = 0;
        for (char task: tasks) {
            count[task - 'A'] += 1;
            maxExec = Math.max(maxExec, count[task - 'A']);
        }
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == maxExec) {
                maxCount += 1;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(taskScheduler.leastInterval(tasks,  2));
    }
}
