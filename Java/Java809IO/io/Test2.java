package WORK.Java.Java809IO.io;

import java.io.*;
import java.util.Date;


public class Test2 {
///Users/julis/Downloads/test.txt
	public static void main(String[] args) throws IOException {
		//InputStream is=System.in;
		String filePath="/Users/julis/Downloads/test.txt";
		FileInputStream fis = new FileInputStream(filePath);
		//System.out.println("请输入：");
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] buf=new byte[1024];
		int len=-1;
		String s=null;
		while((len=bis.read(buf))!=-1) {
			s=new String(buf,0,len);
			System.out.println(s);

		}

		File f=new File(filePath);

		System.out.println(f.isDirectory());
		if(f.isFile()==true) {
			String str=f.getAbsolutePath();
			System.out.println(str);
			long l=f.lastModified();
			Date d=new Date(l);
			System.out.println(d);
			long freespace=f.getFreeSpace();
			System.out.println(freespace+"k");
		}
		else {
			System.out.print("文件不存在");
		}
	}
}
