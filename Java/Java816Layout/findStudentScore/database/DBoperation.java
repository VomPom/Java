package WORK.Java.Java816Layout.findStudentScore.database;

import javax.swing.*;
import java.sql.*;

/**
 * Created by Julis on 17/8/8.
 * User:Julis 落叶挽歌
 * Date:17/8/8
 * Time:下午4:02
 */
public class DBoperation {
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

    public static String queryData(String name,String classNumber, JTextField[] tf) {
        int rowCount=0;
        ResultSet rs=null;
        Connection connection=getConnectino();
        PreparedStatement st=null;
        try {
            //String sql="SELECT *FROM student WHERE name=? or class=?";
            String sql="SELECT * FROM student WHERE name = ?";
            st=connection.prepareStatement(sql);
            st.setString(1,name);
            //st.setString(2,classNumber);
            rs=st.executeQuery();
            System.out.println(name);
            while (rs.next()&&rowCount==0){//如果同名,这里只取了第一个
                rowCount++;
                tf[1].setText(rs.getString("class"));
                tf[2].setText(String.valueOf(rs.getDouble("score")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rowCount==0){
            return "";
        }else{
            return "99.5";

        }
    }


}




