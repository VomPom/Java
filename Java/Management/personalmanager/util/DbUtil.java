package WORK.Java.Management.personalmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DbUtil {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "数据库加载失败");
		}
	}

	public static Connection getConn() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mydata?useSSL=false";
		String user = "root";
		String password = "123456";
		return DriverManager.getConnection(url, user, password);
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "数据库关闭失败");
		}
	}
}
