package interview;

import java.util.*;
/**
 * @author LBW
 */
public class HuaweiTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strTimes = line.split(",");
        int n = strTimes.length;
        int[] taskTimes = new int[n];
        for (int i = 0; i < n; i++) {
            taskTimes[i] = Integer.parseInt(strTimes[i]);
        }
        List<List<Integer>> dependencies = new ArrayList<>(); // dependencies.get(i) 表示 被 i 依赖的项
        for (int i = 0; i < n; i++){
            dependencies.add(new ArrayList<>());
        }
        int[] count = new int[n]; // count[i] 表示 i 还剩几个依赖没有完成
        line = scanner.nextLine();
        String[] deps = line.split(",");
        for (String dep: deps) {
            String[] strs = dep.split("->");
            int left = Integer.parseInt(strs[0]), right = Integer.parseInt(strs[1]);
            count[left] += 1;
            dependencies.get(right).add(left);
        }
        int[] res = new int[n];
        int idx = 0, curTime = 0, p = 0;
        while (p < n) {
            if (count[idx] == 0 && res[idx] == 0) {
                curTime = curTime + taskTimes[idx];
                res[idx] = curTime;
                p += 1;
                // 减少依赖
                for (int dep: dependencies.get(idx)) {
                    count[dep] -= 1;
                }
            }
            idx = (idx + 1) % n;
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.println(res[n - 1]);
    }
}
