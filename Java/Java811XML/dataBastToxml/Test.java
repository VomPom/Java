package Java.Java811XML.dataBastToxml;

import Java.Java811XML.model.Member;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Julis on 17/8/11.
 * User:Julis 落叶挽歌
 * Date:17/8/11
 * Time:下午11:59
 */
public class Test {
    public static void main(String []args) throws TransformerException, ParserConfigurationException {
        ArrayList<Member> members=new ArrayList<>();
        members=getList();
        Java.Java811XML.dom.Test.write(members);
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

    public static ArrayList<Member> getList() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Member> members = new ArrayList<>();
        conn = getConnectino();
        String sql = "select * from user";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Member m1 = new Member();
                m1.setId(Integer.valueOf(rs.getString("id")));
                m1.setName(rs.getString("username"));
                m1.setTel(rs.getString("tel"));
                m1.setAddress(rs.getString("address"));
                members.add(m1);


            }
            return members;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
