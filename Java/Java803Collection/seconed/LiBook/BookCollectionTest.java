package WORK.Java.Java803Collection.seconed.LiBook;

import java.util.ArrayList;
import java.util.Scanner;

public class BookCollectionTest {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("请选择要执行的操作： "+"1.查看  "+"2.增加  "+"3.删除  "+"4.退出");
		ArrayList list=new ArrayList();
		Book b1=new Book(1,"安徒生童话","中外名著",32);
		Book b2=new Book(2,"淘气包马小跳","青少年读物",16);
		Book b3=new Book(3,"朝花夕拾","中外名著",22);
		Book b4=new Book(4,"大耳朵图图","儿童读物",12);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
	while(true) {
		int num=s.nextInt();
		if(num==1) {
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
		if(num==2){
			Book b=new Book();
			System.out.println("请输入要增加的书的编号： ");
			b.setId(s.nextInt());
			System.out.println("请输入要增加的书的书名： ");
			b.setName(s.next());
			System.out.println("请输入要增加的书的类别： ");
			b.setKind(s.next());
			System.out.println("请输入要增加的书的价格： ");
			b.setPrice(s.nextDouble());
			System.out.println("成功增加"+b);
		}
		if(num==3) {
			
		try{
			System.out.println("输入要删除的书的编号");
			int n=s.nextInt();
			boolean b=list.remove(list.get(n));
			if(b==true) {
				System.out.println("删除成功");
			}
			else {
				throw new IndexOutOfBoundsException("输入有误");
			}
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		}
		if(num==4) {
			System.out.println("成功退出");
			return;
		}
		}
	}
}
