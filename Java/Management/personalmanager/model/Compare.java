package WORK.Java.Management.personalmanager.model;

import java.util.Comparator;

public class Compare implements Comparator<Person> {

	private String filed;
	private String order;

	public Compare(String filed, String order) {
		super();
		this.filed = filed;
		this.order = order;
	}

	public Compare() {
		super();
	}

	public int compare(Person o1, Person o2) {

		if ("编号".equals(filed)) {
			if ("升序".equals(order)) {
				return o1.getId() - o2.getId();
			} else if ("降序".equals(order)) {
				return o2.getId() - o1.getId();
			}
		} else if ("性别".equals(filed)) {
			if ("升序".equals(order)) {
				return o1.getSex().compareTo(o2.getSex());
			} else if ("降序".equals(order)) {
				return o2.getSex().compareTo(o1.getSex());
			}
		} else if ("名字".equals(filed)) {
			if ("升序".equals(order)) {
				return o1.getName().compareTo(o2.getName());
			} else if ("降序".equals(order)) {
				return o2.getName().compareTo(o1.getName());
			}
		}else if ("部门".equals(filed)) {
			if ("升序".equals(order)) {
				return o1.getDepartment().compareTo(o2.getDepartment());
			} else if ("降序".equals(order)) {
				return o2.getDepartment().compareTo(o1.getDepartment());
			}
		} else if ("工资".equals(filed)) {
			if ("升序".equals(order)) {
				return o1.getSalary().compareTo(o2.getSalary());
			} else if ("降序".equals(order)) {
				return o2.getSalary().compareTo(o1.getSalary());
			}
		}

		return o1.getId() - o2.getId();// 升序排列
	}

}
