package WORK.Java.Java816Layout.findStudentScore.listener;

import WORK.Java.Java816Layout.findStudentScore.database.DBoperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julis on 17/8/16.
 * User:Julis 落叶挽歌
 * Date:17/8/16
 * Time:下午9:09
 */
public class QueryScoreListener implements ActionListener {
    private String name;
    private String classNumber;
    JTextField[] tf;
    public QueryScoreListener(String name, String classNumber,JTextField[] tf) {
        this.name = name;
        this.classNumber = classNumber;
        this.tf=tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        query();
    }
    public void query(){
        String name=tf[0].getText();
        String classNumber=tf[1].getText();
        String socre="null";
        if(!name.equals("")){
            socre= DBoperation.queryData(name,classNumber,tf);
            if(socre==""){
                JOptionPane.showMessageDialog(null, "没有结果", "没有找到相关数据", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "参数错误", "请输入姓名", JOptionPane.ERROR_MESSAGE);
        }

    }
}
