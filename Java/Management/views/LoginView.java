package WORK.Java.Management.views;

import WORK.Java.Management.listener.LoginListener;

import javax.swing.*;
import java.awt.*;

public class LoginView {
	private static JFrame frame;

	/**
	 * 构造函数 初始化数据
	 */
	public LoginView() {
		initViews();
	}

	public static void initViews(){
		frame =new JFrame("登录");
		JPanel p=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();

		JLabel label1=new JLabel("用户名:");
		label1.setPreferredSize(new Dimension(90, 30) );
		label1.setFont(new Font("楷体",Font.PLAIN,18));
		JTextField tf1=new JTextField();
		tf1.setPreferredSize(new Dimension(120, 30) );
		JLabel label2=new JLabel("密码:");
		label2.setPreferredSize(new Dimension(90, 30) );
		label2.setFont(new Font("楷体",Font.PLAIN,18));
		JPasswordField pass=new JPasswordField();
		pass.setPreferredSize(new Dimension(120, 30) );
		pass.setEchoChar('*');

		p1.add(label1);
		p1.add(tf1);
		p2.add(label2);
		p2.add(pass);


		p1.setOpaque(false);
		p2.setOpaque(false);
		p.add(p1);
		p.add(p2);

		JButton login=new JButton("登录");
		login.addActionListener(new LoginListener(tf1,pass));
		login.setPreferredSize(new Dimension(70, 35) );
		p3.add(login);
		p3.setOpaque(false);
		p.add(p3);


		p.setBackground(new Color(160,178,174));
		frame.getContentPane().add(p);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)d.getWidth()/2-300,(int)d.getHeight()/2-300);
		frame.setSize(new Dimension(300,200));
		frame.setVisible(true);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * 关闭窗口
	 */
	public static void close(){
		frame.dispose();
	}
}


