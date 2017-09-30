package WORK.Java.Management.personalmanager.listener;

import WORK.Java.Management.personalmanager.dao.PersonDao;
import WORK.Java.Management.personalmanager.frame.EditFrame;
import WORK.Java.Management.personalmanager.model.Person;
import WORK.Java.Management.personalmanager.util.Dom4j;
import WORK.Java.Management.personalmanager.util.MyUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;


public class MainListener implements ActionListener {

	public DefaultTableModel dm;
	public JTable table = new JTable(dm);
	public JScrollPane tablePane;
	PersonDao persondao = new PersonDao();

	public MainListener(JTable table) {
		super();
		this.table = table;
	}

	public MainListener() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if ("增加".equals(str)) {
			new EditFrame("增加", table);

		} else if ("删除".equals(str)) {
			dm = (DefaultTableModel) table.getModel();
			int n[] = table.getSelectedRows();

			try {
				int choose = JOptionPane.showConfirmDialog(null, "确定删除？", "提示", JOptionPane.YES_NO_OPTION);

				if (choose == JOptionPane.YES_OPTION) {
					for (int i = n.length - 1; i >= 0; i--) {
						int id = (int) dm.getValueAt(n[i], 0);
						dm.removeRow(n[i]);
						try {
							persondao.deleteperson(id);
						} catch (SQLException e1) {

							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "删除用户失败");
						}
					}

				}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}

		} else if ("修改".equals(str)) {
			int n = table.getSelectedRow();
			if (n >= 0) {
				EditFrame alterframe = new EditFrame("修改", table);

				alterframe.idtxt.setText(String.valueOf(table.getValueAt(n, 0)));
				alterframe.nametxt.setText(String.valueOf(table.getValueAt(n, 1)));
				alterframe.sexbox.setSelectedItem(String.valueOf(table.getValueAt(n, 2)));
				alterframe.departbox.setSelectedItem(String.valueOf(table.getValueAt(n, 3)));
				alterframe.salarytxt.setText(String.valueOf(table.getValueAt(n, 4)));

			} else {
				JOptionPane.showMessageDialog(null, "修改失败，请选择一行");
			}

		} else if ("更新".equals(str)) {

			MyUtil.refresh(table);

		} else if ("查询".equals(str)) {

			EditFrame frame = new EditFrame("查询", table);
			frame.sexbox.setSelectedItem("");
			frame.departbox.setSelectedItem("");

		} else if ("导入".equals(str)) {

			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			chooser.setFileFilter(new FileFilter() {

				@Override
				public String getDescription() {
					return null;
				}

				@Override
				public boolean accept(File f) {
					return f.getName().endsWith(".xml");
				}
			});

			/**
			 * 弹出对话框 选择是否同时更新到数据库
			 */
			File file = chooser.getSelectedFile();
			int n = JOptionPane.showConfirmDialog(null, "是否同时导入到数据库？", "消息", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			ArrayList<Person> people = null;
			try {
				people = Dom4j.read(file);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "xml导入失败");
			}
			if (n == JOptionPane.YES_OPTION) {

				try {

					persondao.insertPerson(people);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "数据重复，继续导入");
				}

				MyUtil.xmlimport(table, people);

			} else if (n == JOptionPane.NO_OPTION) {

				MyUtil.xmlimport(table, people);
			}

		} else if ("导出".equals(str)) {

			JFileChooser chooser = new JFileChooser();
			chooser.showSaveDialog(null);
			chooser.setFileFilter(new FileFilter() {

				@Override
				public String getDescription() {
					return null;
				}

				@Override
				public boolean accept(File f) {
					return f.getName().endsWith(".xml");
				}
			});
			try {
				File file = chooser.getSelectedFile();
				Dom4j.write(table, file);
				JOptionPane.showMessageDialog(null, "导出xml文件成功");
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, "导出xml文件失败");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "导出xml文件失败");
			}

		}

	}

}
