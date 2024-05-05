package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LBW
 */
public class NeteaseThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strs = line.split(" ");
        int[] ages = new int[strs.length];
        for (int i = 0; i < ages.length; i++) {
            ages[i] = Integer.parseInt(strs[i]);
        }
        int[] res = getRes(ages);
        System.out.println(Arrays.stream(res).sum());
    }

    private static int[] getRes(int[] ages) {
        int n = ages.length;
        int[] res = new int[n];
        boolean[] hasRes = new boolean[n];
        int count = 0;
        while (count < n) {
            int min = findMinWithoutRes(ages, hasRes);
            for (int i = 0; i < n; i++) {
                if (ages[i] == min) {
                    int cur = 0;
                    if (ages[i] > ages[(i + n - 1) % n]) {
                        cur = Math.max(cur, res[(i + n - 1) % n]);
                    }
                    if (ages[i] > ages[(i + 1) % n]) {
                        cur = Math.max(cur, res[(i + 1) % n]);
                    }
                    res[i] = cur + 1;
                    hasRes[i] = true;
                    count += 1;
                }
            }
        }
        return res;
    }

    private static int findMinWithoutRes(int[] ages, boolean[] hasRes) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ages.length; i++) {
            if (!hasRes[i]) {
                min = Math.min(min, ages[i]);
            }
        }
        return min;
    }
}
