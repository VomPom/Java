package WORK.Java.Management.personalmanager.listener;

import WORK.Java.Management.personalmanager.model.Compare;
import WORK.Java.Management.personalmanager.model.Person;
import WORK.Java.Management.personalmanager.util.MyUtil;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MouseListener extends MouseAdapter {

	private JTable table;
	private int count = 0;

	public MouseListener(JTable table) {
		super();
		this.table = table;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/**
		 * 双击鼠标 进行排序
		 */

		ArrayList<Person> people1 = new ArrayList<>();
		int row = table.getRowCount();
		DefaultTableModel dm = (DefaultTableModel) table.getModel();

		for (int i = 0; i < row; i++) {
			Person p = new Person();
			
			MyUtil.tableValue(p, table);
			
			dm.removeRow(0);
			people1.add(p);
		}
		Point point = e.getPoint();
		int n = table.columnAtPoint(point);// 获取鼠标点击的位置处于列的索引
		String name = table.getColumnName(n);// 列的名字

		if (e.getClickCount() == 2) {
			count++;
			if (count % 2 == 0) {
				Collections.sort(people1, new Compare(name, "升序"));
			} else {
				Collections.sort(people1, new Compare(name, "降序"));
			}
		}
		
		MyUtil.addrow(people1, table);
	}

}
