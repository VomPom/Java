package WORK.Java.Java726Extends.change;

import java.util.Calendar;

public class CollegeStudent extends Student{
	@Override
	public void graduation() {
		super.graduation();
		System.out.println("College学生毕业时间为:"+
				time.get(Calendar.YEAR)+"年"
				+(time.get(Calendar.MONTH)+1)+"月"
				+time.get(Calendar.DATE)+"日");


	}

}
