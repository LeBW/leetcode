/**
 * 649. Dota2 Senate
 * @author LBW
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int nr = 0, nd = 0;
        for (char c: senate.toCharArray()) {
            if (c == 'R')
                nr += 1;
            else
                nd += 1;
        }
        boolean[] isBanned = new boolean[n];
        int idx = 0;
        for (; nr != 0 && nd != 0; idx = (idx + 1) % n) {
            if (isBanned[idx])
                continue;
            int j = (idx + 1) % n;
            while (senate.charAt(j) == senate.charAt(idx) || isBanned[j])
                j = (j + 1) % n;
            isBanned[j] = true;
            if (senate.charAt(j) == 'R')
                nr -= 1;
            else
                nd -= 1;
        }
        if (nr > 0)
            return "Radiant";
        else
            return "Dire";
    }
}
