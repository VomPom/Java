package WORK.Java.Management.personalmanager.util;

import WORK.Java.Management.personalmanager.dao.PersonDao;
import WORK.Java.Management.personalmanager.frame.EditFrame;
import WORK.Java.Management.personalmanager.model.Person;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MyUtil {

	static PersonDao persondao = new PersonDao();

	// 从数据库更新table
	public static void refresh(JTable table) {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.setRowCount(0);
		try {
			ArrayList<Person> people = persondao.selectAll();

			addrow(people, table);

		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "更新失败！");
		}

	}

	// 从xml导入到table
	public static void xmlimport(JTable table, ArrayList<Person> people) {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.setRowCount(0);
		for (Person p : people) {
			for (int i = 0; i < table.getRowCount(); i++) {
				if (p.getId() == table.getValueAt(i, 0)) {
					dm.removeRow(i);
				}

			}
		}
		addrow(people, table);
	}

	// 修改和新增封装
	public static void addedit(EditFrame editframe, Person p) {
		if (!judgeSalary(editframe)) {
			JOptionPane.showMessageDialog(null, "工资必须为正整数");
			editframe.salarytxt.setText("");
			return;
		}
		p.setName(editframe.nametxt.getText());
		p.setSex(editframe.sexbox.getSelectedItem().toString());
		p.setDepartment(editframe.departbox.getSelectedItem().toString());
		p.setSalary(Integer.valueOf(editframe.salarytxt.getText()));
	}

	// addrow
	public static void addrow(ArrayList<Person> people, JTable table) {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		for (Person p : people) {
			dm.addRow(new Object[] { p.getId(), p.getName(), p.getSex(), p.getDepartment(), p.getSalary() });
		}
	}
	// 给table一条记录赋值

	public static void tableValue(Person p, JTable table) {

		DefaultTableModel dm = (DefaultTableModel) table.getModel();

		p.setId(Integer.valueOf(dm.getValueAt(0, 0).toString()));
		p.setName((String) dm.getValueAt(0, 1));
		p.setSex((String) dm.getValueAt(0, 2));
		p.setDepartment((String) dm.getValueAt(0, 3));
		p.setSalary(Integer.valueOf(dm.getValueAt(0, 4).toString()));

	}

	// 判断工资是否符合要求 正则表达式
	public static boolean judgeSalary(EditFrame editframe) {
		boolean b = editframe.salarytxt.getText().matches("^[1-9][0-9]*");

		return b;

	}

	// 新增代码
	public static void addperson(EditFrame editframe, JTable table) throws SQLException {

		Person p = new Person();

		addedit(editframe, p);

		persondao.addperson(p);
		Person p2 = persondao.selectid();
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.addRow(new Object[] { p2.getId(), p2.getName(), p2.getSex(), p2.getDepartment(), p2.getSalary() });

	}

	// 修改代码
	public static void alterperson(EditFrame editframe, JTable table) throws SQLException {
		int selectid = Integer.valueOf(editframe.idtxt.getText());

		Person p1 = persondao.selectperson(selectid);

		MyUtil.addedit(editframe, p1);
		persondao.alterperson(p1);

		// TODO 修改table中记录
		int row = table.getSelectedRow();

		table.setValueAt(editframe.nametxt.getText(), row, 1);
		table.setValueAt(editframe.sexbox.getSelectedItem(), row, 2);
		table.setValueAt(editframe.departbox.getSelectedItem(), row, 3);
		table.setValueAt(editframe.salarytxt.getText(), row, 4);

	}

	// i == 1:新增
	// i == 2:修改
	public static void add(EditFrame editframe, JTable table, int i) {
		if (!"".equals(editframe.nametxt.getText()) && !"".equals(editframe.salarytxt.getText())) {
			try {
				if (i == 1) {
					addperson(editframe, table);
				}
				if (i == 2) {
					alterperson(editframe, table);
				}
				JOptionPane.showMessageDialog(null, editframe.frametitle + "成功");
				editframe.dispose();

			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, editframe.frametitle + "失败");
			}
		} else if (!"".equals(editframe.nametxt.getText()) && "".equals(editframe.salarytxt.getText())) {
			JOptionPane.showConfirmDialog(null, "姓名不能为空");
		} else if ("".equals(editframe.nametxt.getText()) && !"".equals(editframe.salarytxt.getText())) {
			JOptionPane.showConfirmDialog(null, "工资不能为空");
		} else if ("".equals(editframe.nametxt.getText()) && "".equals(editframe.salarytxt.getText())) {
			JOptionPane.showConfirmDialog(null, "姓名和工资不能为空");
		}

	}

	// 查询封装
	public static void query(EditFrame editframe, JTable table) {
		// 查询的确定
		ArrayList<Person> people = new ArrayList<>();
		Person person = new Person();
		try {
			try {
				person.setId(Integer.valueOf(editframe.idtxt.getText() + '0'));

			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "请输入有效编号");
				editframe.idtxt.setText("");
			}
			person.setName(editframe.nametxt.getText());
			person.setSex(editframe.sexbox.getSelectedItem().toString());
			person.setDepartment(editframe.departbox.getSelectedItem().toString());

			boolean b = MyUtil.judgeSalary(editframe);

			if (b || "".equals(editframe.salarytxt.getText())) {

				person.setSalary(Integer.valueOf(editframe.salarytxt.getText() + '0'));

				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				if (persondao.selectperson(person).size() > 0) {
					people = persondao.selectperson(person);
					dm.setRowCount(0);

					MyUtil.addrow(people, table);

				} else {
					JOptionPane.showMessageDialog(null, "查询无结果");
					dm.setRowCount(0);
				}
			} else if (!b) {
				JOptionPane.showMessageDialog(null, "工资必须为正整数");
				editframe.salarytxt.setText("");
			}
			editframe.dispose();
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "工资请输入正整数");
			editframe.salarytxt.setText("");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
