package WORK.Java.Java803Collection.fifth;

import java.util.Comparator;

public class MyComparator implements Comparator<String>{
	
	private String filed;
	private String order;
	

	public MyComparator(String filed, String order) {
		super();

		this.filed = filed;
		this.order = order;
	}

	public MyComparator() {
		super();
	}

	@Override
	public int compare(String o1, String o2) {

		if("name".equals(filed)) {
			if("升序".equals(order)) {
				return o1.compareTo(o2);//升序排列
			}
			else if("降序".equals(order))
				return o2.compareTo(o1);//降序排列
		}
		return o2.compareTo(o1);//降序排列
	}

}
