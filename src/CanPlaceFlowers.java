/**
 * 605. Can Place Flowers
 * 贪心
 * @author LBW
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0, len = flowerbed.length;
        if (len < 2) {
            res = flowerbed[0] == 0 ? 1 : 0;
            return res >= n;
        }
        //judge 0
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            res += 1;
            flowerbed[0] = 1;
        }
        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                res += 1;
                flowerbed[i] = 1;
            }
        }
        //judge len-1
        if(flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            res += 1;
            flowerbed[len - 1] = 1;
        }
        return res >= n;
    }
}
