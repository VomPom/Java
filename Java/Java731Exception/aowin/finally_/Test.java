package WORK.Java.Java731Exception.aowin.finally_;

public class Test {
	public static void main(String[] args) {
		//test1();
		System.out.println(testReturn());
		System.out.println(testReturn2());
		
		System.out.println(testReturn3()[0]);
	}
	
	
	/**
	 * 返回结果为2 
	 * @return
	 */
	public static int testReturn() {
		int x = 1;
		try {
			x = 2;
			return x;
		}finally {
			x = 3;
			System.out.println("x="+x);
		}
	}
	
	public static int testReturn2() {
		int x = 1;
		try {
			x = 2;
			return x;
		}finally {
			x = 3;
			System.out.println("x="+x);
			return x;
		}
	}
	
	public static int[] testReturn3() {
		int[] a = new int[] {1,2,3,4,5};
		try {
			a[0] = 3;
			return a;
		}finally {
			a[0] = 10;
		}
	}
	
	
	public static void test1() {
		try {
			System.out.println(1/1);
			
			char[] c = new char[6];
			System.out.println(c[8]);
			
			int[] a = new int[-1];
		}catch(ArithmeticException e) {
			//e.printStackTrace();//输出异常的堆栈信息
			System.out.println(2);
		}catch(NegativeArraySizeException e){
			//e.printStackTrace();
			System.out.println(3);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("一定会执行的代码块");
		}
		System.out.println("done");
	}

}
