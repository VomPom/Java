package Java.Management.personalmanager.frame;

import Java.Management.personalmanager.dao.ManagerDao;
import Java.Management.personalmanager.listener.MainListener;
import Java.Management.personalmanager.listener.MouseListener;
import Java.Management.personalmanager.model.Manager;
import Java.Management.personalmanager.model.Person;
import Java.Management.personalmanager.util.MyUtil;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class MainFrame extends JFrame {

	public DefaultTableModel dm;
	public JTable table;
	public JScrollPane tablePane;
	public JLabel title;
	ArrayList<Person> people;


	ManagerDao managerdao = new ManagerDao();
	public MainFrame(String name,String password) {
		super("人事管理界面");
		
		Manager m = null;
		try {
			m = managerdao.login(name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(m.getPassword() == null||m.getUsername() == null) {
			new LoginFrame();
		}else {
			
		BorderLayout border = new BorderLayout(20, 20);
		JPanel panel = new JPanel(border);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");

		JMenuItem add = new JMenuItem("增加");
		JMenuItem delete = new JMenuItem("删除");
		JMenuItem alter = new JMenuItem("修改");
		JMenuItem update = new JMenuItem("更新");
		JMenuItem query = new JMenuItem("查询");
		JMenuItem impor = new JMenuItem("导入");
		JMenuItem export = new JMenuItem("导出");
		file.add(add);
		file.add(delete);
		file.add(alter);
		file.add(update);
		file.add(query);
		file.add(impor);
		file.add(export);

		bar.add(file);
		bar.add(help);
		// 北 ---title
		title = new JLabel("人事管理系统");
		title.setHorizontalAlignment(0);
		panel.add(title, BorderLayout.NORTH);

		// 中 ---table
		dm = new DefaultTableModel(new Object[] { "编号", "名字", "性别", "部门", "工资" }, 0);
		table = new JTable(dm);
		tablePane = new JScrollPane(table);
		panel.add(tablePane);

		
		MyUtil.refresh(table);
		
		// 南 ---buttons
		JPanel p1 = new JPanel();
		JButton add1 = new JButton("增加");
		JButton delete1 = new JButton("删除");
		JButton alter1 = new JButton("修改");
		JButton update1 = new JButton("更新");
		JButton query1 = new JButton("查询");

		MainListener l1 = new MainListener(table);
		delete1.addActionListener(l1);
		alter1.addActionListener(l1);
		add1.addActionListener(l1);
		update1.addActionListener(l1);
		query1.addActionListener(l1);

		add.addActionListener(l1);
		delete.addActionListener(l1);
		alter.addActionListener(l1);
		update.addActionListener(l1);
		query.addActionListener(l1);
		impor.addActionListener(l1);
		export.addActionListener(l1);

		p1.add(add1);
		p1.add(delete1);
		p1.add(alter1);
		p1.add(update1);
		p1.add(query1);

		panel.add(p1, BorderLayout.SOUTH);

		setJMenuBar(bar);
		getContentPane().add(panel);
		setVisible(true);

		setLocation(300, 100);
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTableHeader header = table.getTableHeader();
		MouseListener mouse = new MouseListener(table);
			header.addMouseListener(mouse);

		}
	
	}
	public static void main(String[] args) {
		new MainFrame("", "");
	}	
}
