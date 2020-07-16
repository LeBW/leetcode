import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1079. Letter Tile Possibilities
 * 排列题目，都可以用树形结构的DFS（回溯 + 剪枝）
 * @author LBW
 */
public class LetterTilePossibilities {
    private int result;

    public int numTilePossibilities(String tiles) {
        result = 0;
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[]  used = new boolean[chars.length];
        List<Character> cur = new ArrayList<>();
        backTrack(cur, used, chars);
        return result;
    }

    private void backTrack(List<Character> cur, boolean[] used, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                if (i > 0 && chars[i] == chars[i-1] && !used[i-1])
                    continue;
                cur.add(chars[i]);
                used[i] = true;
                result += 1;
                backTrack(cur, used, chars);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
