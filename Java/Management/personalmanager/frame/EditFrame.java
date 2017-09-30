package WORK.Java.Management.personalmanager.frame;

import WORK.Java.Management.personalmanager.listener.EditListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class EditFrame extends JFrame {

	public JTextField idtxt;
	public JTextField nametxt;
	public JComboBox<String> sexbox;
	public JComboBox<String> departbox;
	public JTextField salarytxt;
	public JButton okbtn;
	public JButton canclebtn;
	public static JTable table;

	public String frametitle;

	public EditFrame(String str, JTable table) {
		super(str);
		frametitle = str;
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);

		JPanel p1 = new JPanel();
		JLabel idlab = new JLabel("编号：");
		idtxt = new JTextField(13);

		p1.add(idlab);
		p1.add(idtxt);

		JPanel p2 = new JPanel();
		JLabel namelab = new JLabel("姓名：");
		nametxt = new JTextField(13);
		p2.add(namelab);
		p2.add(nametxt);

		JPanel p3 = new JPanel();
		JLabel sexlab = new JLabel("性别：                                   ");
		sexbox = new JComboBox<>(new String[] { "", "男", "女" });
		p3.add(sexlab);
		p3.add(sexbox);

		JPanel p4 = new JPanel();
		JLabel departlab = new JLabel("部门:                             ");
		departbox = new JComboBox<>(new String[] { "", "人事部", "行政部", "技术部", "销售部","组织部","后勤部" });
		p4.add(departlab);
		p4.add(departbox);

		JPanel p5 = new JPanel();
		JLabel salarylab = new JLabel("工资：");
		salarytxt = new JTextField(13);
		p5.add(salarylab);
		p5.add(salarytxt);

		JPanel p6 = new JPanel();
		okbtn = new JButton("确定");
		canclebtn = new JButton("取消");
		p6.add(okbtn);
		p6.add(canclebtn);

		EditListener l = new EditListener(this, table);
		okbtn.addActionListener(l);
		canclebtn.addActionListener(l);
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);
		panel.add(p6);

		getContentPane().add(panel);
		setVisible(true);
		setLocation(300, 100);
		pack();
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new EditFrame("修改", table);
	}
}
