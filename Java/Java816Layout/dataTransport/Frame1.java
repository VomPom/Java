package WORK.Java.Java816Layout.dataTransport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julis on 17/8/16.
 * User:Julis 落叶挽歌
 * Date:17/8/16
 * Time:下午9:39
 */
public class Frame1 {
    private static JTextField textField;
    private static boolean flag=true;
    public Frame1() {
       initFrame();
    }
    public void initFrame(){
        JFrame frame=new JFrame("窗口1");
        JPanel jPanel=new JPanel();
        textField=new JTextField(10);
        JButton button=new JButton("发送到窗口2");
        jPanel.add(textField);
        jPanel.add(button);
        frame.add(jPanel);
        frame.setBounds(0,0,400,200);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag==true) {
                    flag=false;
                    new Frame2(textField.getText());
                }
                else{
                    Frame2.changeText(textField.getText());
                }
            }
        });

    }
    public static void changeText(String text){
        textField.setText(text);
    }
}





