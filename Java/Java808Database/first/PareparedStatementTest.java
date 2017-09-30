package WORK.Java.Java808Database.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Julis on 17/8/9.
 * User:Julis 落叶挽歌
 * Date:17/8/9
 * Time:下午4:19
 */
public class PareparedStatementTest {
    public static void main(String[]args){
        Connection  connection =null;
        PreparedStatement stmt =null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //获得数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","root");
            stmt=connection.prepareStatement("UPDATE student set scoere=? WHERE id=?");
            stmt.setDouble(1, 85.0);
            stmt.setInt(2, 124124);
            stmt.addBatch();

            stmt.setDouble(1, 75.0);
            stmt.setInt(2, 124125);
            stmt.addBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
