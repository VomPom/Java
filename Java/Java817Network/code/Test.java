package WORK.Java.Java817Network.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {
	public static void main(String[] args) {
		//url : 网络访问路径的一种表示方式 http://hostname:port/目录路径
		try {
			//创建url对象
			URL url = new URL("http://www.baidu.com");
			//获取输入流对象
			InputStream is = url.openStream();
			
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader br = new BufferedReader(isr);
			
			String str = null;
			while((str=br.readLine())!=null) {
				System.out.print(str);//输出网络地址的源码
			}
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
