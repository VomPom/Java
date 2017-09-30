package WORK.Java.DCL.UI;

import DCL.UI.SingleInputFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julis on 17/8/5.
 * User:Julis 落叶挽歌
 * Date:17/8/5
 * Time:下午2:57
 */

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(2,2,0,0));
        JButton button= new JButton("单因子因素");
        jPanel.add(button);
        this.add(jPanel);
        this.setSize(500,400);
        this.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new SingleInputFrame();
            }
        });
    }



}
