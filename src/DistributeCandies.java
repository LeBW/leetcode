import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies
 * HashSet
 * @author LBW
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
