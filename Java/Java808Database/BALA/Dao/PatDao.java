package WORK.Java.Java808Database.BALA.Dao;

import java.sql.*;
import java.util.ArrayList;

import WORK.Java.Java808Database.BALA.Util.DButil;
import WORK.Java.Java808Database.BALA.demo.Pat;



public class PatDao {
/**
 * 查看宠物信息：显示商店中所有的宠物列表。

 * 
 * @param p
 * @return
 * @throws SQLException 
 */
	public static ArrayList<Pat> select(Pat p) throws SQLException{
		Connection conn=null;
	    Statement st=null;
	    ResultSet rs=null;
	    ArrayList<Pat> pat=new ArrayList<>();
	  try {
		  conn=(Connection) DButil.open();
	      String sql="select * from pat";
	      st=conn.prepareStatement(sql);
	    
	       rs=st.executeQuery(sql);
	    while(rs.next()) {
	    	Pat p1=new Pat();
	    	p1.setName(rs.getString("name"));
	    	p1.setColor(rs.getString("color"));
	    	p1.setPrice(rs.getDouble("price"));
	    	pat.add(p1);
	    	
	    }
	    return pat;
	   
	}finally {
		DButil.close(conn, st, null);
	}
}
/**
 * 
 * 根据颜色搜索宠物
 * @param p
 * @return
 * @throws SQLException 
 */
	public static ArrayList<Pat> select1(Pat p) throws SQLException{
		Connection conn=null;
	    PreparedStatement st=null;
	    ResultSet rs=null;
	    ArrayList<Pat> pat=new ArrayList<>();
	  try {
		  conn=(Connection) DButil.open();
	      String sql="select * from pat where color=?";
	      st=conn.prepareStatement(sql);
	      st.setString(1,p.getColor());
		  System.out.println(p.getColor());
		  rs=st.executeQuery();
	    while(rs.next()) {
	    	Pat p1=new Pat();
	    	p1.setName(rs.getString("name"));
	    	p1.setColor(rs.getString("color"));
	    	p1.setPrice(rs.getDouble("price"));
	    	pat.add(p1);

	    }
	    return pat;
	   
	}finally {
		DButil.close(conn, st, null);
	}
}
	/**
	 * 
	 * 根据宠物名称搜索宠物
	 * @param p
	 * @return
	 * @throws SQLException 
	 */
	public static ArrayList<Pat> select2(Pat p) throws SQLException{
		Connection conn=null;
	    PreparedStatement st=null;
	    ResultSet rs=null;
	    ArrayList<Pat> pat=new ArrayList<>();
	  try {
		  conn=(Connection) DButil.open();
	      String sql="select * from pat where name=?";
	      st=conn.prepareStatement(sql);
	      st.setString(1, p.getName());
		  rs=st.executeQuery(sql);
	    while(rs.next()) {
	    	Pat p1=new Pat();
	    	p1.setName(rs.getString("name"));
	    	p1.setColor(rs.getString("color"));
	    	p1.setPrice(rs.getDouble("price"));
	    	pat.add(p1);
	    	
	    }
	    return pat;
	   
	}finally {
		DButil.close(conn, st, null);
	}
}
	/**
	 * 
	 * 将数据库中的宠物删除
	 * @param name
	 * @return 
	 * @throws SQLException
	 */
	public static int delete(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = (Connection) DButil.open();
			String sql = "delete from pat where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			return ps.executeUpdate();
		}finally {
			DButil.close(conn, ps, null);
		}
	}
	/**
	 * 修改宠物的价格
	 * @return 
	 * 
	 */
	public static int update(Pat p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = (Connection) DButil.open();
			String sql = "update pat set price=? where name=?";
			
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, p.getPrice());
			ps.setString(2, p.getName());
			
			
			return ps.executeUpdate();
			
		}finally {
			DButil.close(conn, ps, null);
		}
	}
	
	
}