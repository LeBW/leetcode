import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 * 每日温度。暴力法 O(n^2).
 * 单调栈（递减）时间复杂度 O(n)
 * @author LBW
 */
public class DailyTemperatures {
    /**
     * 暴力法。时间复杂度 O（n^2)
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /* 单调栈。时间复杂度 O（n）*/
    public int[] dailyTemperaturesTwo(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int cur = stack.pop();
                res[cur] = i - cur;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        dailyTemperatures.dailyTemperaturesTwo(new int[]{73,74,75,71,69,72,76,73});
    }
}
