package WORK.Java.DCL.UI;

import DCL.bean.SingleInputBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julis on 17/8/5.
 * User:Julis 落叶挽歌
 * Date:17/8/5
 * Time:下午3:08
 */
public class SingleInputFrame extends JFrame {
    private final int NUMBER=4;
    private JLabel[] jLabels=new JLabel[NUMBER];
    private JTextField[] jTextFields=new JTextField[NUMBER];
    private JPanel[] jPanels=new JPanel[NUMBER];

    public SingleInputFrame() throws HeadlessException {
        setTitle("洞察力");
        setBounds(100, 100, 500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame();
        setVisible(true);
    }
    public void initFrame(){
        String name[]={"因子","区组","因子水平","K"};
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(5,1,0,0));

        for(int i=0;i<NUMBER;i++){
            jPanels[i]=new JPanel();
            jPanels[i].setLayout(new FlowLayout());
            jTextFields[i]=new JTextField(20);

            jLabels[i]=new JLabel(name[i]);
            jPanels[i].add(jLabels[i]);
            jPanels[i].add(jTextFields[i]);
            jPanel.add(jPanels[i]);
        }
        Button submit=new Button("确定");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingleInputBean singleInputBean=new SingleInputBean();
                singleInputBean.setFactor(Integer.parseInt(jTextFields[0].getText()));
                singleInputBean.setGroup(Integer.parseInt(jTextFields[1].getText()));
                singleInputBean.setLeves(Integer.parseInt(jTextFields[2].getText()));
                singleInputBean.setK(Integer.parseInt(jTextFields[3].getText()));
                System.out.println(singleInputBean.toString());

            }
        });
        jPanel.add(submit);
        this.add(jPanel);
    }
}











