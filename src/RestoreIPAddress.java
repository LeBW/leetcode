import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * @author LBW
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        if (s == null)
            return null;

        List<String> result = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12)
            return result;

        int i1 = 0, i2 = 1, i3 = 2;
        addIfValid(s, i1, i2, i3, result);
        while (true) {
            // go to next or trackBack
            if (i3 < len - 2) {
                i3 += 1;
            }
            else if (i3 - i2 > 1) {
                i2 += 1;
                i3 = i2 + 1;
            }
            else if (i2 - i1 > 1) {
                i1 += 1;
                i2 = i1 + 1;
                i3 = i2 + 1;
            }
            else {
                break;
            }
            // judge
            addIfValid(s, i1, i2, i3, result);
        }
        return result;

    }

    private void addIfValid(String s, int i1, int i2, int i3, List<String> result) {
        String s1 = s.substring(0, i1 + 1), s2 = s.substring(i1 + 1, i2 + 1), s3 = s.substring(i2 + 1, i3 + 1), s4 = s.substring(i3 + 1);
        if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
            StringBuilder bf = new StringBuilder(s);
            bf.insert(i3 + 1, '.');
            bf.insert(i2 + 1, '.');
            bf.insert(i1 + 1, '.');
            result.add(bf.toString());
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 3)
            return false;
        if (s.length() > 1 && s.startsWith("0"))
            return false;
        int i = Integer.parseInt(s);
        if (i > 255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        List<String> result = restoreIPAddress.restoreIpAddresses("0279245587303");
        System.out.println(result.toString());
    }
}
