package Java.Management.listener;


import Java.Management.bean.Person;
import Java.Management.data.DataAndXML;
import Java.Management.data.PersonDao;
import Java.Management.views.MainView;
import Java.Management.views.PersonalView;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Julis on 17/8/18.
 * User:Julis 落叶挽歌
 * Date:17/8/18
 * Time:上午10:44
 */
public class MainListener implements ActionListener {
    private JButton[]buttons;
    private JMenuItem []jMenuItems;
    private static JTable  table;
    public MainListener(JButton[] buttons,JTable table,JMenuItem []jMenuItems) {
        this.table=table;
        this.buttons = buttons;
        this.jMenuItems=jMenuItems;

    }

    /**
     * 对按钮事件的监听
     * @param e 获取点击的按钮对象
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object=e.getSource();
        if(object==buttons[0]||object==jMenuItems[0]){//打开增加数据视图
            new PersonalView("增加");
        }else if(object==buttons[1]||object==jMenuItems[1]){//删除数据
            try {
                deletData();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }else if(object==buttons[2]){//修改按钮;
            changeData();
        }else if(object==buttons[3]){//刷新数据
            refreshData();
        }else if(object==buttons[4]||object==jMenuItems[2]){//查询按钮
            new PersonalView("查询");
        }else if(object==jMenuItems[3]){//导人数据操作
            XMLToData();
        }else if(object==jMenuItems[4]){//导出数据操作
            dataToXML();
        }else if(object==jMenuItems[5]){//退出按钮
            System.exit(0);
        }
    }
    /*
    *    删除数据的操作
    * */
    public void deletData() throws SQLException {
        int col = table.getSelectedColumn();//获取选中的列号
        int row = table.getSelectedRow();//获取选中的行号
        /**
         * 判断是否选择列
         */
        if(row!=-1){
            DefaultTableModel model = (DefaultTableModel) table.getModel();//获取defaulttablemodel
            String getId = model.getValueAt(row,0).toString(); //根据行号和列号，获取某个单元格的值,这里获取ID
            String name=model.getValueAt(row,1).toString();
            int n = JOptionPane.showConfirmDialog(null, "你确认删除\""+name+"\"吗?", "确认删除框", JOptionPane.CANCEL_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                model.removeRow(row);//删除选中的那行
                PersonDao.deleteInfo(getId);
            }

        }else{
            JOptionPane.showMessageDialog(null,"你未选中某一行!","消息提示框",JOptionPane.ERROR_MESSAGE);
        }
       //  model.setValueAt(val, row, col);//修改某单元格的值
    }



    /*
    *    刷新数据的操作
    * */
    public void refreshData(){
        MainView.resetData();
        MainView.refreshData();
    }
    /*
    *    导出数据到XML的操作
    *    1\获取当前表中的数据
    *    2\加入到ArrayList
    *    3\导出
    * */
    public void dataToXML(){
        try {
            ArrayList<Person> persons=new ArrayList<>();
            int rowCount=table.getRowCount();//获取列表行数
            int colCount=table.getColumnCount();//获取列表行数
            /**
             * 从表格中获取数据
             */
            for(int i=0;i<rowCount;i++){
                Person person=new Person();
                person.setId(Integer.parseInt((String) table.getValueAt(i,0)));
                person.setName((String) table.getValueAt(i,1));
                person.setSex((String) table.getValueAt(i,2));
                person.setDepartment((String) table.getValueAt(i,3));
                person.setSalary(Float.parseFloat((String) table.getValueAt(i,4)));
                persons.add(person);
           }
            /**
             * 执行导出操作
             */
            DataAndXML.write(persons);



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();

     }
    }
    /*
    *    导入XML数据到数据库操作
    * */
    public void XMLToData(){
        /*
        * 获取文件路径
        * */
        String filePaht=null;
        JFileChooser chooser = new JFileChooser();//文件选择器
        chooser.setApproveButtonText("确定");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  //设置只选择目录

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filePaht=chooser.getSelectedFile().getPath();//获取文件路径
            //System.out.println("You chose to open this file: " +filePaht);
        }
         /*
        * 文件写入数据库
        * */
        ArrayList<Person> persons;
        try {
            int OKcount=0;
            int NOcount=0;
            persons=DataAndXML.XMLToData(filePaht);
            //System.out.println("Dom读取xml成功");
            for(int i=0;i<persons.size();i++){
                Person member=persons.get(i);
                if(PersonDao.insertData(member,false)){
                    OKcount++;
                }else {
                    NOcount++;
                }
            }
            JOptionPane.showMessageDialog(null,
                    "提示消息","导入"+OKcount+"条成功成功!"
                            +NOcount+"条失败!",JOptionPane.OK_OPTION);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取选中主界面的 ID,方便之后对数据库操作
     * @return ID
     */
    public static String getChooseID(){
        int col = table.getSelectedColumn();//获取选中的列号
        int row = table.getSelectedRow();//获取选中的行号
        DefaultTableModel model = (DefaultTableModel) table.getModel();//获取defaulttablemodel
        String getId = model.getValueAt(row,0).toString();
        return getId;
    }
    /*
    *   从数据库中获取指定ID的person对象
    * */
    public static Person getNeedChangePerson() throws SQLException {
        Person person=PersonDao.findByID(getChooseID());
        return person;
    }

    /**
     * 修改数据操作
     * 因为设置到相关数据操作之间的转移,所以这个步骤比较繁琐
     * */

    public void changeData(){
        try {
            Person person=this.getNeedChangePerson();
            PersonalView personalView=new PersonalView("修改");
            personalView.setViewData(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}







