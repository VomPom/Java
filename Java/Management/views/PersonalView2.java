package Java.Management.views;

import Java.Management.bean.Person;
import Java.Management.listener.PersonalViewListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class PersonalView2 {

	private static JTextField nameField;
	private static JComboBox sexBox;
	private static JComboBox departmentBox;
	private static JTextField salaryField;
	private static String type;
	private static JFrame frame;

	public PersonalView2(String type) {
		this.type=type;
		initViews();
	}

	public static void main(String[] args) {
		initViews();
	}

	public static void initViews() {
		frame=new JFrame(type+"操作");
		FlowLayout l=new FlowLayout(FlowLayout.LEFT,0,0);
		GridLayout g=new GridLayout(1,2,0,30);
	
		JPanel p=new JPanel(l);
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		JPanel p7=new JPanel(g);
		p7.setBorder(new EmptyBorder(20,75,20,80));
		

		
		JLabel label2=new JLabel("名字：");
		label2.setPreferredSize(new Dimension(150,30));
		label2.setFont(new Font("楷体",Font.BOLD,20));

		nameField=new JTextField();
		nameField.setPreferredSize(new Dimension(150,30));
		
		p2.add(label2);
		p2.add(nameField);
		p.add(p2);
		
		
		JLabel label3=new JLabel("性别：");
		label3.setPreferredSize(new Dimension(150,30));
		label3.setFont(new Font("楷体",Font.BOLD,20));
		
		JRadioButton male=new JRadioButton("男");
		male.setFont(new Font("楷体",Font.PLAIN,20));
		male.setPreferredSize(new Dimension(150,30));
		male.setOpaque(false);
		p3.add(label3);
		p3.add(male);
		p.add(p3);
		
		JLabel label4=new JLabel();
		label4.setPreferredSize(new Dimension(150,30));
		JRadioButton female=new JRadioButton("女");
		female.setFont(new Font("楷体",Font.PLAIN,20));
		female.setPreferredSize(new Dimension(150,30));
		female.setOpaque(false);
		p4.add(label4);
		p4.add(female);
		p.add(p4);
		sexBox= new JComboBox();
		sexBox.add(male);
		sexBox.add(female);
		
		JLabel label5=new JLabel("部门：");
		label5.setPreferredSize(new Dimension(150,30));
		label5.setFont(new Font("楷体",Font.BOLD,20));
		departmentBox=new JComboBox<>(new String[] {"","炊事班","市场部","人事部","经理","后勤","财务部"});
		departmentBox.setPreferredSize(new Dimension(150,30));
		departmentBox.setFont(new Font("楷体",Font.BOLD,20));
		
	    p5.add(label5);
	    p5.add(departmentBox);
	    p.add(p5);
	    

		JLabel label6=new JLabel("工资：");
		label6.setPreferredSize(new Dimension(150,30));
		label6.setFont(new Font("楷体",Font.BOLD,20));

		salaryField=new JTextField();
		salaryField.setPreferredSize(new Dimension(150,30));
		
		p6.add(label6);
		p6.add(salaryField);
		p.add(p6);

		
	    
		JButton b1=new JButton("提交");
		b1.addActionListener(new PersonalViewListener(nameField,sexBox,departmentBox,salaryField,type));

		b1.setPreferredSize(new Dimension(80,30));
		JButton b2=new JButton("重置");
		b2.setPreferredSize(new Dimension(80,30));
		
		p7.add(b1);
		p7.add(b2);
		p.add(p7);
	    
		p1.setBackground(new Color(148,170,214));
		p2.setBackground(new Color(135,206,235));
		p3.setBackground(new Color(135,206,235));
		p4.setBackground(new Color(135,206,235));
		p5.setBackground(new Color(176,224,230));
		p6.setBackground(new Color(176,224,230));
		p7.setBackground(new Color(249,205,193));
		
		p.setOpaque(false);
		
		frame.getContentPane().add(p);
	    
		
		frame.setSize(new Dimension(330, 350));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	public static void resetData(){
		nameField.setText("");
		salaryField.setText("");
		sexBox.setSelectedIndex(0);
		departmentBox.setSelectedIndex(0);
	}
	public static void close(){//关闭窗口
		frame.dispose();
	}

	/*
    * 给视图图设置数据
    * */
	public static void setViewData(Person person){
		nameField.setText(person.getName());
		int i=0;
		String departMent=person.getDepartment();
		sexBox.setSelectedIndex(person.getSex()=="男"?1:2);
		String[] departmentName={"","炊事班","市场部","人事部","经理","后勤","财务部"};
		for(i=0;i<departmentName.length;i++){
			if(departmentName[i].equals(departMent))
				break;
		}
		departmentBox.setSelectedIndex(i);
		salaryField.setText(String.valueOf(person.getSalary()));

	}
}
