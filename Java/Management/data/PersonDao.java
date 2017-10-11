package Java.Management.data;



import Java.Management.bean.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class PersonDao {

	private static final String DATABESE_NAME="staff";//数据库名字
	public static ArrayList<Person> getAllData() throws SQLException{
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
			ArrayList<Person> persons=new ArrayList<>();
		  try {
			  conn=(Connection) DButil.open();
			  String sql="select * from staff";
			  st=conn.prepareStatement(sql);

			   rs=st.executeQuery(sql);
			while(rs.next()) {
				Person person=new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setSex(rs.getInt("sex")==1?"男":"女");
				person.setDepartment(rs.getString("department"));
				person.setSalary(rs.getFloat("salary"));
				persons.add(person);
			}
			return persons;

		}finally {
			DButil.close(conn, st, null);
		}

	}
	public static boolean insertData(Person person,Boolean flag){
		System.out.println("插入数据");
		String sql="";
		Connection conn=null;
		PreparedStatement st=null;
		System.out.println(person.getName());
		try {
			conn=DButil.open();
			if(flag) {
				sql = "INSERT INTO "+DATABESE_NAME+"(id,name,sex,department,salary)VALUE(null,?,?,?,?)";
				st=conn.prepareStatement(sql);
				st.setString(1, person.getName());
				st.setInt(2,person.getSex().equals("男")?1:0);
				st.setString(3,person.getDepartment());
				st.setFloat(4,person.getSalary());
			}
			else {
				sql = "INSERT INTO "+DATABESE_NAME+"(id,name,sex,department,salary)VALUE(?,?,?,?,?)";
				st=conn.prepareStatement(sql);
				st.setInt(1,person.getId());
				st.setString(2, person.getName());
				st.setInt(3,person.getSex().equals("男")?1:0);
				st.setString(4,person.getDepartment());
				st.setFloat(5,person.getSalary());
			}



			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	public static ArrayList<Person> queryData(Person person){
		System.out.println("查询数据");
		Connection conn=null;
		PreparedStatement st=null;
		ArrayList<Person> persons=new ArrayList<>();
		ResultSet rs=null;
		int count=1;
		int number=1;
		HashMap<Integer,Object> map=new HashMap<>();
		/**
		 * 对输入的数据判断
		 */
		String tempSql="SELECT *FROM "+DATABESE_NAME+" WHERE 1=1";
		StringBuilder sql=new StringBuilder(tempSql);
		if(!person.getName().isEmpty()){
			sql.append(" and name=?");
			map.put(count++,person.getName());
		}
		if(!person.getSex().isEmpty()){
			sql.append(" and sex=?");
			map.put(count++,person.getSex().equals("男")?1:0);
		}
		if(!person.getDepartment().isEmpty()){
			sql.append(" and department=?");
			map.put(count++,person.getDepartment());
		}
		if(person.getSalary()!=0){
			sql.append(" and salary=?");
			map.put(count++,person.getSalary());
		}
		try {
			conn=DButil.open();

				st=conn.prepareStatement(String.valueOf(sql));
				if(!person.getName().isEmpty()){
					st.setString(number++, person.getName());
				}
				if(!person.getSex().isEmpty()){
					st.setInt(number++,person.getSex().equals("男")?1:0);
				}
				if(!person.getDepartment().isEmpty()){
					st.setString(number++, person.getDepartment());
				}
				if(person.getSalary()!=0){
					st.setFloat(number++,person.getSalary());
				}

				rs=st.executeQuery();
			while(rs.next()) {
				Person p=new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getInt("sex")==1?"男":"女");
				p.setDepartment(rs.getString("department"));
				p.setSalary(rs.getFloat("salary"));
				persons.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}

	public static Person findByID(String id){
		Person person=new Person();
		System.out.println("查询数据");
		String sql="";
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DButil.open();

			sql = "SELECT *FROM "+DATABESE_NAME+" WHERE id=?";
			st=conn.prepareStatement(sql);
			st.setString(1, id);
			rs=st.executeQuery();
			while(rs.next()) {
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setSex(rs.getInt("sex")==1?"男":"女");
				person.setDepartment(rs.getString("department"));
				person.setSalary(rs.getFloat("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
	public static int deleteInfo(String personID) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = (Connection) DButil.open();
			String sql = "delete from "+DATABESE_NAME+" where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, personID);
			return ps.executeUpdate();
		}finally {
			DButil.close(conn, ps, null);
		}
	}
	/*
	*修改操作
	* */
	public static void changeData(Person person){
		System.out.println("更新数据");
		String sql="";
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DButil.open();

			sql = "update "+DATABESE_NAME+" set name=?,sex=?,department=?,salary=? where id=?";
			st=conn.prepareStatement(sql);
			st.setString(1, person.getName());
			st.setInt(2,person.getSex().equals("男")?1:0);
			st.setString(3,person.getDepartment());
			st.setFloat(4,person.getSalary());
			st.setInt(5,person.getId());
			int i=st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}