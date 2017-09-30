package WORK.Java.Management.listener;

import WORK.Java.Management.Comparator.MyComparator;
import WORK.Java.Management.bean.Person;
import WORK.Java.Management.data.PersonDao;
import WORK.Java.Management.views.MainView;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Julis on 17/8/19.
 * User:Julis 落叶挽歌
 * Date:17/8/19
 * Time:下午1:12
 */
public class TableHeaderListener implements MouseListener {
    private  JTableHeader tableHeader;

    public TableHeaderListener(JTableHeader tableHeader) {
        this.tableHeader = tableHeader;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tableHeader){


            int i = tableHeader.columnAtPoint(e.getPoint());
            System.out.println("表头"+i);
            try {
                ArrayList<Person> persons= PersonDao.getAllData();
                persons.sort(new MyComparator(i));
                MainView.resetData();
                MainView.addData(persons);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
