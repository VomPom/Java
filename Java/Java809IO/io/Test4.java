package WORK.Java.Java809IO.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/**
		 * 
		 * 一个程序用于序列化一个会员（Member）对象（用户名，密码，性别，地址…），但是不允许序列化会员的密码。
		 */
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.txt"));
		
		Member m=new Member();
		m.setUsername("123");
		m.setSex("女");
		m.setPassword("1234560");
		m.setAddress("上海");
		
		oos.writeObject(m);//对象序列化
		oos.flush();
		oos.close();
		
		
		/**
		 * 
		 * 用来读取序列化的学生对象。

		 */
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
		Object obj = ois.readObject();//对象反序列化
		if(obj instanceof Member) {
			Member m1=(Member)obj;
			System.out.println(m1);
			
		}
		ois.close();
		
		
		
	}
}
