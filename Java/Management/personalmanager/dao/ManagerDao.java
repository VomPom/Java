package Java.Management.personalmanager.dao;

import Java.Management.personalmanager.model.Manager;
import Java.Management.personalmanager.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ManagerDao {

	public Manager login(String name, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DbUtil.getConn();
			String sql = "select * from manager where username = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			Manager manager = new Manager();
			
			while(rs.next()) {
				manager.setUsername(rs.getString("username"));
				manager.setPassword(rs.getString("password"));
				
			}
			return manager;
			
		} finally {
			DbUtil.close(conn, ps, rs);
		}
		
	}
}
