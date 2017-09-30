package WORK.Java.Management.views;

import WORK.Java.Management.bean.Person;
import WORK.Java.Management.listener.PersonalViewListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Julis on 17/8/18.
 * User:Julis 落叶挽歌
 * Date:17/8/18
 * Time:上午10:57
 */
public class PersonalView {
    private static JTextField nameField;
    private static JComboBox sexBox;
    private static JComboBox departmentBox;
    private static JTextField salaryField;
    private static String type;
    private static JFrame frame;
    public PersonalView(String type) {
        this.type=type;
        initView();
    }
    public void initView(){
        frame=new JFrame(type+"操作");
        String[] barNames={"姓名","性别","部门","工资"};
        frame.setBounds(500,200,500,100);
        JPanel jPanel=new JPanel(new FlowLayout());
        JPanel infoJpanel=new JPanel(new FlowLayout());

        //姓名一栏
        JLabel labelName=new JLabel(barNames[0]);
        nameField=new JTextField(5);
        infoJpanel.add(labelName);
        infoJpanel.add(nameField);

        //性别一栏
        JLabel labelSex=new JLabel(barNames[1]);
        infoJpanel.add(labelSex);
        sexBox=new JComboBox(new String[]{"","男","女"});
        infoJpanel.add(sexBox);


        //部门一栏
        String[] departmentName={"","炊事班","市场部","人事部","经理","后勤","财务部"};
        departmentBox=new JComboBox(departmentName);
        infoJpanel.add(departmentBox);


        //工资一栏
        JLabel labelSalary=new JLabel(barNames[3]);
        salaryField=new JTextField(5);
        infoJpanel.add(labelSalary);
        infoJpanel.add(salaryField);


        JButton enter=new JButton("确定");
        jPanel.add(infoJpanel);
        jPanel.add(enter);
        enter.addActionListener(new PersonalViewListener(nameField,sexBox,departmentBox,salaryField,type));
        frame.add(jPanel);
        frame.setVisible(true);
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









