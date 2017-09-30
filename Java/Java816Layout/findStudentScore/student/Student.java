package WORK.Java.Java816Layout.findStudentScore.student;

import WORK.Java.Java816Layout.findStudentScore.listener.ClearListener;
import WORK.Java.Java816Layout.findStudentScore.listener.QueryScoreListener;
import WORK.Java.Java816Layout.findStudentScore.myframe.Myframe;

import javax.swing.*;
import java.awt.*;


public class Student {

	public static void main(String[] args) {
		JFrame frame=new Myframe("");
		BorderLayout border=new BorderLayout();
		JPanel p=new JPanel(border);
		
		GridLayout grid1 =new GridLayout(3,1);
		JPanel p1=new JPanel(grid1);
		String[] str1=new String[] {"姓名","班级","成绩"};
		JLabel[] lab=new JLabel[str1.length];
		for(int i=0;i<str1.length;i++) {
			lab[i]=new JLabel();
			lab[i].setPreferredSize(new Dimension(150, 30) );
			lab[i].setText(str1[i]);
			p1.add(lab[i]);
		}
		p.add(p1,BorderLayout.WEST);
		
		
		JPanel p2=new JPanel(grid1);
		String[] str2=new String[] {"","",""};
		JTextField[] tf=new JTextField[str2.length];
		
		for(int i=0;i<str2.length;i++) {
			tf[i]=new JTextField(str2[i]);
			
			p2.add(tf[i]);
		}
		p.add(p2,BorderLayout.CENTER);
		
		GridLayout grid2=new GridLayout(1,2);
		JPanel p3=new JPanel(grid2);
		String[] str3=new String[] {"查询","清空"};
		JButton[] btn=new JButton[str3.length];

		for(int i=0;i<str3.length;i++) {
			btn[i]=new JButton(str3[i]);
			p3.add(btn[i]);
			
		}
		//给查询按钮设置监听事件
		String socre="null";
		String name=tf[0].getText();
		String classNumber=tf[1].getText();
		btn[0].addActionListener(new QueryScoreListener(name,classNumber,tf));

		//给晴空按钮设置监听事件
		btn[1].addActionListener(new ClearListener(tf));


		p.add(p3,BorderLayout.SOUTH);
		frame.getContentPane().add(p);
		frame.setSize(300,300);
	}

}


