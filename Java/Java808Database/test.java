package WORK.Java.Java808Database;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Julis on 17/7/20.
 * User:Julis 落叶挽歌
 * Date:17/7/20
 * Time:下午2:00
 */
public class test {
    public static void main(String []args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/julis/Downloads/test.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] buf = new byte[1024];
        int len = -1;
        try {
            while((len=bis.read(buf)) != -1) {
                String str= new String(buf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bis.close();
    }
}
