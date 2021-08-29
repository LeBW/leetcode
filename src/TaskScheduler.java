import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
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

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(taskScheduler.leastInterval(tasks,  2));
    }
}
