package Java.Management.listener;

import Java.Management.bean.Person;
import Java.Management.data.PersonDao;
import Java.Management.views.MainView;
import Java.Management.views.PersonalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Julis on 17/8/18.
 * User:Julis 落叶挽歌
 * Date:17/8/18
 * Time:下午12:29
 */

public class PersonalViewListener implements ActionListener {

    private JTextField nameField;
    private JComboBox sexBox;
    private JComboBox departmentBox;
    private JTextField salaryField;
    private String type;

    public PersonalViewListener(JTextField nameField, JComboBox sexBox, JComboBox departmentBox, JTextField salaryField, String type) {
        this.nameField = nameField;
        this.sexBox = sexBox;
        this.departmentBox = departmentBox;
        this.salaryField = salaryField;
        this.type = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        judgeType();

    }
    public void judgeType(){
        if(type=="增加"){
            addDataToDataBase();
        }else if(type=="查询"){
            queryData();
        }else if(type=="修改"){
            changeData();
        }
    }

    /*
    * 向数据库插入数据
    * */
    public void addDataToDataBase(){
        System.out.println();
        Person person=new Person();
        person.setName(nameField.getText());
        person.setSex(sexBox.getSelectedItem().toString());
        person.setDepartment(departmentBox.getSelectedItem().toString());
        person.setSalary(Float.parseFloat(salaryField.getText()));
        if(PersonDao.insertData(person,true)){//判断是否插入成功
            MainView.refreshData();
            PersonalView.resetData();
        }else{
            JOptionPane.showMessageDialog(null,"插入失败!","消息提示框",JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
    *查询数据
    * */
    public void queryData(){
        Person person=new Person();

        if(!salaryField.getText().equals("")){
            person.setSalary(Float.parseFloat(salaryField.getText()));
        }
        person.setName(nameField.getText());
        person.setSex(sexBox.getSelectedItem().toString());
        person.setDepartment(departmentBox.getSelectedItem().toString());

        ArrayList<Person> persons = PersonDao.queryData(person);//获取到查询得到之后的person数组
        if(persons.size()==0){
            //System.out.println("没有找数据");
            JOptionPane.showMessageDialog(null,"提示信息","没有找到数据!",JOptionPane.ERROR_MESSAGE);
        }else{
            //System.out.println("有"+persons.size()+"条数据");
            MainView.resetData();//将主界面清空
            MainView.addData(persons);//主界面加入数据
            PersonalView.close();//关闭查询窗口
        }

    }
    /*
    * 修改数据
    * */
    public void changeData(){
        //获取 新的person数据对象
        Person person=new Person();
        person.setName(nameField.getText());
        person.setSex(sexBox.getSelectedItem().toString());
        person.setDepartment(departmentBox.getSelectedItem().toString());
        person.setSalary(Float.parseFloat(salaryField.getText()));
        //获取原先的ID
        person.setId(Integer.parseInt(MainListener.getChooseID()));

        PersonDao.changeData(person);
        MainView.refreshData();
        PersonalView.close();


    }

}






















