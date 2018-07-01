import java.util.ArrayList;

/**
 * ZigZag Conversion.
 * @author LBW
 */
public class Zconvert {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        //init lists
        ArrayList<ArrayList<Character>> lists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ArrayList<Character> list = new ArrayList<>();
            lists.add(list);
        }

        int len = s.length();
        //put char into arrayList
        for (int i = 0; i < len; i++) {
            int j = i % (2*numRows-2);
            j = j < numRows ? j : 2*numRows-2-j;
            lists.get(j).add(s.charAt(i));
        }
        //get result
        StringBuilder result = new StringBuilder();
        for (ArrayList<Character> list: lists) {
            for (Character c: list) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Zconvert zconvert = new Zconvert();
        String result = zconvert.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
}
