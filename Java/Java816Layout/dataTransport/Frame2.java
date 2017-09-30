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
public class Frame2 {
    private static JTextField textField;
    public Frame2(String text) {
       initFrame(text);
    }
    public void initFrame(String text){
        JFrame frame=new JFrame("窗口2");
        JPanel jPanel=new JPanel();
        textField=new JTextField(10);
        textField.setText(text);
        JButton button=new JButton("发送到窗口1");
        jPanel.add(textField);
        jPanel.add(button);
        frame.add(jPanel);
        frame.setBounds(420,0,400,200);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame1.changeText(textField.getText());
            }
        });

    }
    public static void changeText(String text){
        textField.setText(text);
    }
}
