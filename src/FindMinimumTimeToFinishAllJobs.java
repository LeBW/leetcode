import java.util.Arrays;
import java.util.Date;

/**
 * 1723. Find Minimum Time to Finish All Jobs
 * 回溯 + 剪枝
 * @author LBW
 */
public class FindMinimumTimeToFinishAllJobs {
    private int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        dfs(0, jobs, 0, workers, 0);
        return res;
    }

    /*
    idx: 当前为第 idx 个 jobs 分配
    max: 当前最大的工人工作时间
    */
    private void dfs(int idx, int[] jobs, int used, int[] workers, int max) {
        if (max >= res) {  // 如果 res 比较小，那么这里可以剪大量的枝
            return;
        }
        if (idx == jobs.length) {
            res = max;
            return;
        }
        // jobs[idx] 可以分配给任一 worker. 这里分两种情况：
        // 1. 现在还有工人未分配，因此随便挑选一个未分配的工人，即可代表这种情况。
        if (used < workers.length) {
            workers[used] = jobs[idx];
            dfs(idx + 1, jobs, used + 1, workers, Math.max(max, workers[used]));
            workers[used] = 0;
        }
        // 2. 遍历所有分配过工作的工人，每一个都是不同的情况。
        // 注意这里的遍历终止条件一定是 used，而不是 workers.length，否则会使 used 失去其含义。
        for (int i = 0; i < used; i++) {
            workers[i] += jobs[idx];
            dfs(idx + 1, jobs, used, workers, Math.max(max, workers[i]));
            workers[i] -= jobs[idx];
        }
    }

    public static void main(String[] args) {
        FindMinimumTimeToFinishAllJobs findMinimumTimeToFinishAllJobs = new FindMinimumTimeToFinishAllJobs();
        System.out.println(System.currentTimeMillis());
        int res = findMinimumTimeToFinishAllJobs.minimumTimeRequired(new int[]{254,256,256,254,251,256,254,253,255,251,251,255}, 10);
        System.out.println(res);
        System.out.println(System.currentTimeMillis());
    }
}
