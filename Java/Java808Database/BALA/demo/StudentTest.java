package WORK.Java.Java808Database.BALA.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import WORK.Java.Java808Database.BALA.Util.DButil;



public class StudentTest {

	public static void main(String[] args) {
		try {
		ArrayList<Student> student=new ArrayList();
		student.add(new Student(1,77));
		student.add(new Student(2,76));
		student.add(new Student(3,75));
		student.add(new Student(4,74));
		
		update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update(ArrayList<Student> student) throws SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn= DButil.open();
			String sql="update student set score=? where id=?";
			ps= (PreparedStatement) conn.prepareStatement(sql);
			for(int i=0;i<student.size();i++) {
				Student s=student.get(i);


				//第一种方式
				ps.setInt(1, s.getId());
				ps.setDouble(2,s.getScore());
		        //ps.addBatch();
				ps.addBatch("update student set score=? where id=?");

				//第二种方式

				ps.addBatch("update student set score="+s.getScore()+" where id="+s.getId());




			}
			ps.executeBatch();
		} 
		finally {
			DButil.close(conn, ps, null);
		}
	}
}



