package Java.Management.listener;

import Java.Management.views.LoginView;
import Java.Management.views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julis on 17/8/19.
 * User:Julis 落叶挽歌
 * Date:17/8/19
 * Time:下午2:14
 */
public class LoginListener implements ActionListener {
    private JTextField name;
    private JPasswordField passwordField;

    public LoginListener(JTextField name, JPasswordField passwordField) {
        this.name = name;
        this.passwordField = passwordField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        judge();
    }
    public void judge(){
        /**
         * 从输入框获取数据
         */
        String userName=name.getText();
        String password= String.valueOf(passwordField.getPassword());
        // System.out.println("name:"+userName+"pass:"+password);
        /**
         * 手动判断 or 从数据库获取数据
         */
        if(userName.equals("root")&&password.equals("root")){
            /**
             * 启动主程序并关闭本窗口
             */
            LoginView.close();
            new MainView();
        }else{
            /**
             * 弹出提示框
             */
            JOptionPane.showMessageDialog(null,"密码或用户名错误","消息提示",JOptionPane.ERROR_MESSAGE);
        }
    }

}






