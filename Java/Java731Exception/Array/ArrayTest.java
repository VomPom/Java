package WORK.Java.Java731Exception.Array;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int[] a=new int[10];
		System.out.println("依次输入数组的值：");
		for(int i=0;i<a.length;i++) {
			a[i]=s.nextInt();
		}
		Index(s,a,0);
		System.out.println(IndexNum(s,a, 0));
		
	}
	

	public static void Index(Scanner s,int[] a,int index) {
		System.out.println("输入数组中的第几位：");
		index=s.nextInt();
		try {
		if(index>=0&&index<a.length) {
			System.out.println(a[index]);
		}
		}
		catch(MyArrayIndexOutOfBoundsException e){
			System.out.println("超出数组范围");
		}
	}
	public static int IndexNum(Scanner s,int[] a,int index) {
		System.out.println("输入指定的值：");
		index=s.nextInt();
	    for(int i = 0;i<a.length;i++) {
			if(index==a[i]) {
				return i;
			} 
		}
		
      throw new NumberNotFoundException("没有找到指定的值"+index);
		
	}
}
