import java.util.HashMap;

/**
 * @author LBW
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        String result = "";
        while (num > 0) {
            int cur = maxPosition(num);
            result += map.get(cur);
            num -= cur;
        }
        return result;
    }

    private int maxPosition(int num) {
        if (num >= 1000)
            return 1000;
        else if (num >= 900)
            return 900;
        else if (num >= 500)
            return 500;
        else if (num >= 400)
            return 400;
        else if (num >= 100)
            return 100;
        else if (num >= 90)
            return 90;
        else if (num >= 50)
            return 50;
        else if (num >= 40)
            return 40;
        else if (num >= 10)
            return 10;
        else if (num >= 9)
            return 9;
        else if (num >= 5)
            return 5;
        else if (num >= 4)
            return 4;
        else if (num >= 1)
            return 1;
        return -1;
    }

}
