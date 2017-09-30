package WORK.Java.Java726Extends.change;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {
	public GregorianCalendar time;
	
    public void graduation() {
		System.out.println("普通学生毕业时间为:"+
				time.get(Calendar.YEAR)+"年"
				+time.get(Calendar.MONTH)+"月"
				+time.get(Calendar.DATE)+"日");
	}
	public GregorianCalendar getTime() {
		return time;
	}

	public void setTime(GregorianCalendar time) {
		this.time = time;
	}
	
	

}
