package WORK.Java.Java809IO.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) {
		/**
		 * 输出字符串3.1415926到文件data.txt中
		 */
		try {
			FileWriter fw = new FileWriter("data.txt", true);
			String str = "3.1415926";

			fw.write(str);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * 
		 * 从data.txt中读入数据，并转换成double类型。
		 */
		FileReader fr;
		try {
			fr = new FileReader("data.txt");
			char[] cuf = new char[1024];
			int len = -1;
            String s=null;
			while ((len = fr.read(cuf)) != -1) {
				s = new String(cuf, 0, len);
				System.out.println(s);
			}
			double d = Double.valueOf(s);
				System.out.println(d);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
