package WORK.Java.Java731Exception.aowin.demo;

public class RuntimeExceptionTest {
	public static void main(String[] args) {
		/*try {
			String str = toUpperCase(null);
			System.out.println(str);
		}catch (NullPointerException e) {
			//System.out.println("输入的字符串为null");
			e.printStackTrace();
		}*/
		try {
			
			String str = "abcdefd";
			System.out.println(str.charAt(1));//StringIndexOutOfBoundsException
			
			int[] a = new int[] {1,2,3,4,5};
			for(int i=1;i<=5;i++) {
				System.out.println(a[i]);//ArrayIndexOutOfBoundsException数组越界异常
		}
		}catch (StringIndexOutOfBoundsException e) {
			System.out.println("字符串索引越界");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组索引越界");
		}
		
		System.out.println("done");
		
		
	}
	
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}

}
