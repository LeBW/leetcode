/**
 * @author LBW
 */
package zzy;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;
import java.util.InputMismatchException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//  34 5 3 5 6 4 33 2 2 4
public class TestBuffer {

    private static int BUFFER_SIZE = 1 * 1024 * 1024;
    private static String filename = "trace1.data";

    public static void main(String[] args) throws IOException{
        //方法一：不使用Buffer字节流
//        long t1 = System.currentTimeMillis();
//        FileInputStream is = new FileInputStream(filename);
//        int b, tmp;  // by为读取到的单个字节
//        ArrayList<Integer> list = new ArrayList<>(); //使用动态整形数组存储每行的每个字节的对应整数，然后再复制到对应长度的byte[]数组中
//        while((b = is.read()) != -1){  //逐个读取字节
//
//            if (b != 10 && b != 13) {
//                list.add(b);
//            } else {
//                if (list.size() == 0) continue;
//                byte[] bys = new byte[list.size()];
//                for (int i = 0; i < list.size(); i++){
//                    tmp = list.get(i);
//                    bys[i] = (byte)tmp;
//                }
//                list.clear();
//            }
//        }
//        is.close();

        //方法二  BufferedInputStream逐行读
        System.out.println("BufferedInputStream: ");
        long t2 = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bys = new byte[1024];
        byte[] bysCopy;
        int by, index = 0;  // by为读取到的单个字节
        while((by = bis.read()) != -1){  //逐个读取字节

            if (by != 10 && by != 13) {
                bys[index++] = (byte)by;
            } else {
                if (index == 0) continue;
                bysCopy = new byte[index];

                //System.arraycopy(bys, 0, bysCopy, 0, index);
                index = 0; //一行读取结束，index重置为0

            }
        }
        bis.close();
        System.out.println(System.currentTimeMillis() - t2);

        //方法三 readLine  + getBytes方法
        System.out.println("BufferedReader ReadLine: ");
        long t3 = System.currentTimeMillis();

        FileInputStream fis2 = new FileInputStream(filename);
        BufferedReader bf = new BufferedReader(new InputStreamReader(fis2));
        String line;
        int len, tm;
        while((line = bf.readLine()) != null){  //逐个读取字节
            byte[] byss = line.getBytes();
        }

        bf.close();

//        System.out.println("方法一耗时为：" + (terminal - t1));
        System.out.println(System.currentTimeMillis() - t3);
    }







}



