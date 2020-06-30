import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author LBW
 */
public class Test {
    public void foo(String str, String path) throws IOException {
        String alpStr = alpConcatenate(str);
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(alpStr);
    }

    private String alpConcatenate(String str) {
        StringBuilder alpStr = new StringBuilder();
        int i = 0;
        while (i <= str.length()) {
            if (Character.isLetter(str.charAt(i))) {
                alpStr.append(str.charAt(i));
            }
            else {
                continue;
            }
            i++;
        }
        return alpStr.toString();
    }
}
