package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LBW
 */
public class MeituanThird {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] place = new int[n];
        String[] direction = new String[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            place[i] = scanner.nextInt();
            direction[i] = scanner.next();
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        while (t < 1000) {
            //move(place, direction);

        }

    }
}
