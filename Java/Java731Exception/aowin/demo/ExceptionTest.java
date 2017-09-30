package WORK.Java.Java731Exception.aowin.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionTest {
	public static void main(String[] args) {
		/*try {
			String str = read();
			System.out.println("您输入了内容："+str);
		} catch (IOException e) {
			System.out.println("程序执行过程中出现了IOException");
			e.printStackTrace();//输出异常的具体信息
		}*/
		
		
		/*String str = read2();
		System.out.println("您输入了内容："+str);*/
		
		
		try {
			Date date = parseDate("2017-0731 10:09:09");
		} catch (ParseException e) {
			System.out.println("日期格式不正确");
			e.printStackTrace();
		}
	}
	/**
	 * 声明异常
	 * IOException 编译期异常
	 * @return
	 * @throws IOException
	 */
	public static String read() throws IOException {
		byte[] buf = new byte[1024];
		System.out.println("请输入一段内容");
		InputStream is = System.in;
		
		//is.close();//关闭输入流
		is.read(buf);
		String str = new String(buf);
		return str;
	}
	/**
	 * 在方法中处理了异常
	 * @return
	 */
	public static String read2() {
		byte[] buf = new byte[1024];
		System.out.println("请输入一段内容");
		InputStream is = System.in;
		
		try {
			is.close();//关闭输入流
			is.read(buf);
		}catch (IOException e) {
			System.out.println("方法read2调用中出现了IOExeption");
		}
		//即使以上代码出现了异常 下面的程序还是会继续执行
		String str = new String(buf);
		return str;
	}
	
	
	public static Date parseDate(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(time);
		return d;
		
	}
}
