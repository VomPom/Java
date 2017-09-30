package WORK.Java.Java808Database.BALA.demo;

import WORK.Java.Java808Database.BALA.Util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		User u = new User();
		System.out.println("请输入用户名：");
		int id = s.nextInt();
		System.out.println("请输入密码：");
		int password = s.nextInt();
		u.setUserid(id);
		u.setPassword(password);
		try {
			ArrayList<User> user = select(u);
			System.out.println(u);
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("该用户未注册，请选择下列操作：1.注册新用户   2.退出系统");
			int i = s.nextInt();
			if (i == 1) {
				insertuser(u);
				System.out.println(u);
			} else {
				System.out.println("退出成功");
				return;
			}
		}

	}

	private static void insertuser(User u) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DButil.open();

			String sql = "insert into user (userid,password) values (?,?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, u.getUserid());
			ps.setInt(2, u.getPassword());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, ps, null);// 关闭连接
		}
	}

	public static ArrayList<User> select(User u) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> user = new ArrayList();
		try {
			conn = DButil.open();
			String sql = "select * from user where userid=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserid());
			ps.setInt(2, u.getPassword());

			rs = ps.executeQuery();
			while (rs.next()) {
				User u1 = new User();
				u1.setUserid(rs.getInt("userid"));
				u1.setName(rs.getString("name"));
				u1.setPassword(rs.getInt("password"));
				u1.setAddress(rs.getString("address"));
				u1.setBirthday(rs.getString("birthday"));
				u1.setSex(rs.getString("sex"));
				u1.setPhonenumber(rs.getInt("phonenumber"));
				user.add(u1);
			}
			return user;
		} finally {
			DButil.close(conn, ps, null);
		}

	}
}
