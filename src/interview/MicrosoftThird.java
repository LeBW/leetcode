package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MicrosoftThird {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        int[] sorted = Arrays.copyOf(A, n);
        Arrays.sort(sorted);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            set1.add(A[i]);
            set2.add(sorted[i]);
            if (set1.equals(set2)) {
                res += 1;
                set1.clear();
                set2.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MicrosoftThird microsoftThird = new MicrosoftThird();
        System.out.println(microsoftThird.solution(new int[]{2, 4, 1, 6, 5, 9, 7}));
    }
}
