package WORK.Java.Java808Database.BALA.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
	static {
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @throws SQLException
	 * 
	 */
	public static Connection open() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdata?useSSL=false", "root", "root");
	}

	/**
	 * 关闭连接
	 * 
	 */
	public static void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
                conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
