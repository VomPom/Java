package WORK.Java.Java731Exception.aowin.throwExe;

public class Test {
	
	public static void main(String[] args) {
		//编译期异常
		try {
			int i = findNumber(new int[] {12,45,67,89},41);
			System.out.println("找到的数字索引为："+i);
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());//打印异常消息
		}
		
		//运行期异常
		isLeapYear(2003);
	}
	
	/**
	 * 从数组a中查询数字num
	 * 并且返回它的索引
	 * 如果找不到就抛出异常
	 * @param a
	 * @param num
	 * @return
	 */
	public static int findNumber(int[] a,int num) throws Exception{
		for(int i=0;i<a.length;i++) {
			if(num == a[i]) {
				return i;
			}
		}
		//抛出编译期异常异常 
		throw new Exception("找不到"+num+"数字");//抛出异常后，该方法已经结束 之后不能再写任何代码
	}
	
	/**
	 * 判断一个年份是否是闰年
	 * 如果是 返回true
	 * 否则抛出异常
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year){
		if((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			return true;
		}
		throw new RuntimeException("不是一个闰年");
	}

}
