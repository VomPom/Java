package WORK.Java.Management.personalmanager.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import WORK.Java.Management.personalmanager.dao.PersonDao;
import WORK.Java.Management.personalmanager.frame.EditFrame;
import WORK.Java.Management.personalmanager.util.MyUtil;

public class EditListener implements ActionListener {

	private EditFrame editframe;
	private JTable table;

	PersonDao persondao = new PersonDao();

	public EditListener(EditFrame editframe, JTable table) {
		super();
		this.editframe = editframe;
		this.table = table;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if ("确定".equals(str)) {
			if ("增加".equals(editframe.frametitle)) {

				MyUtil.add(editframe, table, 1);

			} else if ("修改".equals(editframe.frametitle)) {

				MyUtil.add(editframe, table, 2);

			} else if ("查询".equals(editframe.frametitle)) {

				MyUtil.query(editframe, table);

			} else if ("取消".equals(str)) {
				if ("增加".equals(editframe.frametitle)) {
					
					editframe.dispose();

				} else if ("修改".equals(editframe.frametitle)) {
					
					editframe.dispose();
				}
			}

		}

	}
}
