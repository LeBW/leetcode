import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * 动态规划
 * @author LBW
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];  //动态规划
        dp[0] = true;
        for (int i = 1; i < len + 1; i++) {
            //遍历wordDict做尝试，如果存在某个word使得dp[i]满足，则dp[i]=true
            for (String str: wordDict) {
                int l = str.length();
                if (i - l >= 0 && dp[i-l] && s.substring(i-l, i).equals(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak.wordBreak("leetcode", wordDict);
    }
}
