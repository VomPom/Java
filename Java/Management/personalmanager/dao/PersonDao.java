package Java.Management.personalmanager.dao;

import Java.Management.personalmanager.model.Person;
import Java.Management.personalmanager.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class PersonDao {

	//查询所有用户，显示在table中
	public ArrayList<Person> selectAll() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			String sql = "select * from person";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			ArrayList<Person> people = new ArrayList<>();
			while(rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setDepartment(rs.getString("department"));
				person.setName(rs.getString("name"));
				person.setSalary(rs.getInt("salary"));
				person.setSex(rs.getString("sex"));
				
				people.add(person);
			}
			
			return people;
		}finally {
			DbUtil.close(conn, ps, rs);
		}
	}
	
	//根据id查询用户
	public Person selectperson(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = DbUtil.getConn();
			String sql = "select * from person where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
		
			Person person = new Person();
			while(rs.next()) {
				person.setId(rs.getInt("id"));
				person.setDepartment(rs.getString("department"));
				person.setName(rs.getString("name"));
				person.setSalary(rs.getInt("salary"));
				person.setSex(rs.getString("sex"));
				
			}
			return person;
		}finally {
			DbUtil.close(conn, ps, rs);
		}
	}
	
	
	
	//新增用户 从窗口增加
	public int addperson(Person person) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {

			conn = DbUtil.getConn();
			String sql = "insert into person(name,sex,department,salary) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setString(2, person.getSex());
			ps.setString(3,person.getDepartment());
			ps.setInt(4, person.getSalary());
			
			int n = ps.executeUpdate();
			
			return n;
			
		}finally {
			DbUtil.close(conn, ps, null);
		}
		
	}
	
	
	//导入增加person 批处理
	
	public void insertPerson(ArrayList<Person> people) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtil.getConn();
			String sql = "insert into person (id,name,sex,department,salary) values (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			//给?赋值
			for(int i=0;i<people.size();i++) {
				Person person = people.get(i);
				ps.setInt(1, person.getId());
				ps.setString(2, person.getName());
				ps.setString(3, person.getSex());
				ps.setString(4, person.getDepartment());
				ps.setInt(5, person.getSalary());
				
				ps.addBatch();
			}
			//执行sql
			 ps.executeBatch();
		}finally {
			DbUtil.close(conn, ps, null);
		}
	}
	
	//删除用户
	public int deleteperson(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DbUtil.getConn();
			String sql = "delete from person where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int n = ps.executeUpdate();
			
			return n;
			
		}finally {
			DbUtil.close(conn, ps, null);
		}
		
	}
	
	/*//批量删除
	public void deleteBatch(int n[]) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DbUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "delete from person where id = ?";
			ps = conn.prepareStatement(sql);
			for(int i = 0;i<n.length;i++) {
				
				ps.setInt(1, n[i]);
				ps.addBatch();
			}
			
			int id[] = ps.executeBatch();
			
			for(int i = 0;i<id.length;i++) {
				if(id[i] !=1) {
					conn.rollback();
					throw new Exception("修改失败！");
				}
			}
			conn.commit();
			
		}finally {
			DbUtil.close(conn, ps, null);
		}
		
	}
	*/
	//修改person
	public int alterperson(Person p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DbUtil.getConn();
			String sql = "update person set name = ?,sex = ?,department = ?,salary = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getSex());
			ps.setString(3, p.getDepartment());
			ps.setInt(4, p.getSalary());
			ps.setInt(5, p.getId());
			
			int n = ps.executeUpdate();
			return n;
			
		}finally {
			DbUtil.close(conn, ps, null);
		}
		
	}
	
	//新增person到数据库 table 到table时要获取id
	public Person selectid() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DbUtil.getConn();
			String sql = "select * from person where id = (select max(id) from person )";
			ps = conn.prepareStatement(sql);
			
			 rs = ps.executeQuery();
			 
			 Person person = new Person();
				while(rs.next()) {
					person.setId(rs.getInt("id"));
					person.setDepartment(rs.getString("department"));
					person.setName(rs.getString("name"));
					person.setSalary(rs.getInt("salary"));
					person.setSex(rs.getString("sex"));
					
				}
				return person;
			}finally {
				DbUtil.close(conn, ps, rs);
			}
	}
	
	//查询person 字符串拼接
	
	public ArrayList<Person> selectperson(Person person) throws SQLException{
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Person> people = new ArrayList<>();
		try {
			conn = DbUtil.getConn();
			int count = 0;//记录?的数字
			//用来保存查询条件 键 保存当前条件的顺序 值 条件的具体值
			HashMap<Integer, Object> map = new HashMap<>();
			StringBuilder sql = new StringBuilder("select * from person where true ");
			if(!isEmpty(person.getName())) {
				sql.append(" and name like concat('%',?,'%')");
				map.put(++count, person.getName());
			}
			if(!isEmpty(person.getSex())) {
				sql.append(" and sex = ?");
				map.put(++count, person.getSex());
			}
			if(!isEmpty(person.getDepartment())) {
				sql.append(" and department = ?");
				map.put(++count, person.getDepartment());
			}
			if(person.getId() != null && person.getId() !=0 ) {
				sql.append(" and id = ?");
				map.put(++count, person.getId());
			}
			ps = conn.prepareStatement(sql.toString());
			//给sql中的?赋值
			for(int key:map.keySet()) {
				ps.setObject(key, map.get(key));
			}
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setDepartment(rs.getString("department"));
				p.setName(rs.getString("name"));
				p.setSalary(rs.getInt("salary"));
				p.setSex(rs.getString("sex"));
				people.add(p);
			}
			
			return people;
		}finally {
			DbUtil.close(conn, ps, rs);
		}
		
	}
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
}
