package Java.Java811XML.inserToDatabase;

import Java.Java811XML.model.Member;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julis on 17/8/11.
 * User:Julis 落叶挽歌
 * Date:17/8/11
 * Time:下午11:43
 */
public class Test {

    public static void main(String []args) throws IOException, SAXException, ParserConfigurationException, SQLException {
        ArrayList<Member> readMembers=new ArrayList<>();
        readMembers=Java.Java811XML.dom.Test.read();
        System.out.println("Dom读取xml成功");
        System.out.println(readMembers.size());
        insertData(readMembers);
//        for(int i=0;i<readMembers.size();i++){
//            Member member=readMembers.get(i);
//            System.out.println("ID="+member.getId());
//            System.out.println("Name="+member.getName());
//            System.out.println("Address="+member.getAddress());
//            System.out.println("Tel="+member.getTel()+"\n");
//        }

    }

    public static void insertData(List<Member> members) throws SQLException {
       Connection connection= getConnectino();
        PreparedStatement stmt =null;
        stmt=connection.prepareStatement("INSERT INTO user(id,username,address,tel) values(?,?,?,?)");

        for(int i=0;i<members.size();i++){
            Member member=members.get(i);

            if(member.getId() instanceof Integer
                    &&member.getName() instanceof  String
                    &&member.getAddress() instanceof  String
                    &&member.getTel() instanceof  String) {

                stmt.setInt(1,member.getId());
                stmt.setString(2,member.getName());
                stmt.setString(3,member.getAddress());
                stmt.setString(4,member.getTel());
                stmt.addBatch();
            }else{
                System.err.println("数据不合法");
            }

        }
        stmt.executeBatch();
    }




    public static Connection getConnectino(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
