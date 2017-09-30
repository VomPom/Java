package WORK.Java.Management.personalmanager.frame;

import WORK.Java.Management.personalmanager.dao.ManagerDao;
import WORK.Java.Management.personalmanager.model.Manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LoginFrame extends JFrame {

	
	
	public LoginFrame() {
		super("登陆界面");
		//GridLayout grid = new GridLayout(4, 2, 10, 10);
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		panel.setBorder(new EmptyBorder(30, 20, 30, 20));

		JPanel p1 = new JPanel();
		JLabel namelab = new JLabel("用户名：");
		JTextField nametxt = new JTextField(15);
		
		JPanel p2 = new JPanel();
		JLabel passLab = new JLabel("密码：    ");
		JPasswordField passtxt = new JPasswordField(15);
		
		JPanel p3 = new JPanel();
		JButton loginbtn = new JButton("登陆");
		
		JPanel p4 = new JPanel();
		JLabel hintlab = new JLabel("");
		
		hintlab.setForeground(Color.RED);

		// 登陆按钮的事件
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerDao managerdao = new ManagerDao();
					Manager m = managerdao.login(nametxt.getText(),String.valueOf(passtxt.getPassword()));
					if (m.getUsername() != null && m.getPassword() != null) {
							JOptionPane.showMessageDialog(null, "登陆成功");
							new MainFrame(m.getUsername(),m.getPassword());
							setVisible(false);
						} else {
							hintlab.setText("用户名或密码错误");
						}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		p1.add(namelab);
		p1.add(nametxt);
		p2.add(passLab);
		p2.add(passtxt);
		p3.add(loginbtn);
		p4.add(hintlab);

		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		
		getContentPane().add(panel);
		setVisible(true);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) d.getWidth() / 2 - 200, (int) d.getHeight() / 2 - 150);

		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
