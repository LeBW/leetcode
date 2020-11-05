import java.util.*;

/**
 * 127. Word Ladder
 * 广度优先搜索。
 * 将word看作节点，不同节点间如果只相差一个字母，则用边相连。
 * 最后的问题就是找到beginWord和endWord之间的最短路径（利用BFS）.
 * 注意：这里不需要提前建图，只需要在遍历到某个word的时候，计算它与其他节点的距离，找到相邻节点即可。
 * 注意：在记录已经访问过的节点时，使用下表索引数组boolean[] isVisited 比 使用单词哈希表 Set<String> 快很多。
 * @author LBW
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
//        Set<String> isVisited = new HashSet<>();
//        isVisited.add(beginWord);
        boolean[] isVisited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            isVisited[idx] = true;
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step += 1;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 找到所有与word只差一个字母的单词
                for (int j = 0; j < wordList.size(); j++) {
                    String w = wordList.get(j);
                    if (!isVisited[j] && isDifferentOnlyOneLetter(w, word)) {
                        queue.add(w);
                        isVisited[j] = true;
                        if (w.equals(endWord)) {
                            return step;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean isDifferentOnlyOneLetter(String word1, String word2) {
        int n = word1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count += 1;
                if (count > 1)
                    return false;
            }
        }
        return count == 1;
    }
}
