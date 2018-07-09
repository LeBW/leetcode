/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' matches any single character.
 * '*' matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * @author LBW
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return backWard(0, 0, s, p);
    }

    private boolean backWard(int si, int pi, String s, String p) {
        //if matching ends, return true.
        if (s.length() == si && p.length() == pi)
            return true;
        //if p ends but s doesn't ends, return false.
        else if (s.length() != si && p.length() == pi)
            return false;
        //if s ends but p doesn't ends
        else if (s.length() == si) {
            if (pi < p.length() - 1 && p.charAt(pi+1) == '*')
                return backWard(si, pi+2, s, p);
            else return false;
        }

        //normal situation.
        if (p.charAt(pi) == '.') {
            //if the next char is '*'
            if (pi < p.length() - 1 && p.charAt(pi+1) == '*') {
                for (int t = si; t <= s.length(); t++) {
                    if (backWard(t, pi+2, s, p))
                        return true;
                }
                return false;
            }
            else {
                return (backWard(si+1, pi+1, s, p));
            }
        }
        else if (p.charAt(pi) == '*')
            return false;
        else { //if p.charAt(pi) is a-z
            if (pi < p.length() - 1 && p.charAt(pi+1) == '*') {
                if (backWard(si, pi+2, s, p))
                    return true;
                for (int t = si; t < s.length() && s.charAt(t) == p.charAt(pi); t++) {
                    if (backWard(t+1, pi+2, s, p))
                        return true;
                }
                return false;
            }
            else {
                if (p.charAt(pi) == s.charAt(si))
                    return backWard(si+1, pi+1, s, p);
                else return false;
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("a", "ab*a"));
    }

}
