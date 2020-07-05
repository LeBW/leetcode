import java.io.*;

/**
 * @author LBW
 */
public class Test {
    private static int BUFFER_SIZE = 1 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        testBufferInputStream();
        testBufferReader();
        testBufferReaderLine();
    }

    private static void testBufferInputStream() throws IOException{
        System.out.println("Test Buffer Input Stream: ");
        long startTime = System.currentTimeMillis();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("trace1.data"));
        try {
            byte[] bytebuffer = new byte[BUFFER_SIZE];
            int numberofBytes;
            do {
                numberofBytes = inputStream.read(bytebuffer, 0, BUFFER_SIZE);
            } while (numberofBytes >= 0);
        }
        finally {
            inputStream.close();
            System.out.println(System.currentTimeMillis() - startTime);
        }
    }

    private static void testBufferReader() throws IOException{
        System.out.println("Test Buffer Reader: ");
        long startTime = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("trace1.data"), BUFFER_SIZE);
        try {
            char[] charBuffer = new char[BUFFER_SIZE];
            int numOfChars;
            do {
                numOfChars = reader.read(charBuffer, 0, BUFFER_SIZE);
            } while (numOfChars >= 0);
        }
        finally {
            reader.close();
            System.out.println(System.currentTimeMillis() - startTime);
        }
    }

    private static void testBufferReaderLine() throws IOException{
        System.out.println("Test Buffer Reader readLine: ");
        long startTime = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("trace1.data"), BUFFER_SIZE);
        String line = reader.readLine();
        try {
            while (line != null)
                line = reader.readLine();
        }
        finally {
            reader.close();
            System.out.println(System.currentTimeMillis() - startTime);
        }
    }
}
