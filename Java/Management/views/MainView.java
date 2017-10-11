package Java.Management.views;

import Java.Management.bean.Person;
import Java.Management.data.PersonDao;
import Java.Management.listener.MainListener;
import Java.Management.listener.TableHeaderListener;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MainView {
	private static DefaultTableModel tm;
	private static JTable table;
	private static JButton []buttons;
	private static JMenuItem []jMenuItems;
	private static JTableHeader tableHeader;

	public MainView() {
		initViews();
		refreshData();
	}

	public static void main(String[] args) throws SQLException {
		initViews();
		refreshData();
	}
	public static void initViews(){
		buttons=new JButton[5];
		jMenuItems=new JMenuItem[6];
		JFrame frame = new JFrame();//创建swing窗口
		JPanel p=new JPanel();//创建容器，默认流式布局

		//标题
		JLabel label =new JLabel();//不可以编辑的文本标签
		label.setText("人事管理系统");
		label.setFont(new Font("楷体",Font.BOLD,15));
		label.setPreferredSize(new Dimension(100,30));
		p.add(label);

		/*
		* 菜单
		* */
		JMenu file =new JMenu("文件");//添加导航菜单
		JMenu help =new JMenu("帮助");
		String [] nameJMenuItem={"添加","删除","查询","导入","导出","退出"};
		for(int i=0;i<nameJMenuItem.length;i++){
			jMenuItems[i]=new JMenuItem(nameJMenuItem[i]);
			file.add(jMenuItems[i]);
			jMenuItems[i].addActionListener(new MainListener(buttons,table,jMenuItems));
			if(i==2||i==4){
				file.addSeparator();
			}
		}
		JMenuBar bar=new JMenuBar();
		bar.add(file);
		bar.add(help);
		frame.setJMenuBar(bar);

		/*
		* 表单
		* */
		JPanel p1=new JPanel();
		tm=new DefaultTableModel(new Object[] {"工号","名字","性别","部门","工资"},0);
		table =new JTable(tm);
		tableHeader=table.getTableHeader();//获取表头
		tableHeader.addMouseListener(new TableHeaderListener(tableHeader));//表头添加监听事件
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
		table.setDefaultRenderer(Object.class, tcr);//设置渲染器
		Color mycolor =new Color(249,205,173);
		table.setGridColor(mycolor);//设置表哥颜色
		JScrollPane tablePane=new JScrollPane(table);
		p1.add(tablePane);
		p.add(p1);

		/*
		* 几个按钮
		* */
		JPanel p2=new JPanel();
		String []buttonsName={"添加","删除","修改","更新","查询"};
		ButtonGroup b=new ButtonGroup();
		for(int i=0;i<buttons.length;i++){
			buttons[i]=new JButton(buttonsName[i]);
			buttons[i].addActionListener(new MainListener(buttons,table,jMenuItems));
			b.add(buttons[i]);
			p2.add(buttons[i]);
		}
		p.add(p2);



		frame.getContentPane().add(p);
		frame.setSize(new Dimension(500,600));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭操作
	}

	/**
	 * 向主界面添加数据
	 *
	 * 遍历ArrayList里面的person数据,将其一个一个加入到主界面
	 * @param persons
     */
	public static void addData(ArrayList<Person> persons){
		for(Person person:persons){
			tm.addRow(new String[]{String.valueOf(person.getId()),person.getName(),
					person.getSex(),person.getDepartment(), String.valueOf(person.getSalary())});
		}

	}

	/**
	 * 刷新主界面数据视图
	 */
	public static void refreshData(){
		resetData();//清空数据
		ArrayList<Person> persons= null;
		try {
			persons = PersonDao.getAllData();//获取所有的person对象
			for(int i=0;i<persons.size();i++){
				Person person=persons.get(i);
				tm.addRow(new String[]{String.valueOf(person.getId()),
						person.getName(),person.getSex(),person.getDepartment(),
						String.valueOf(person.getSalary())});//将数据库的数据载入初始化的界面中
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 *清空数据
	 */
	public static void resetData(){
		tm.setRowCount(0);
	}

}
