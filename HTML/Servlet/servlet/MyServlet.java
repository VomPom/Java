package WORK.HTML.Servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.PreparedStatement;




public class MyServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println(username+"\n"+password);
		StringBuilder userpass=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebdata?userSSL=true","root","ldn19960603");
		 	PreparedStatement ps=null;
		 	ResultSet rs =null;
		 	String sql="select * from user where username=? ";
		 	ps.setString(1, username);
		 	rs=ps.executeQuery();
		 	while(rs.next()) {
		 		userpass.append(rs.getString("password"));
		 	}
		 	conn.close();
		 	ps.close();
		 	rs.close();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out=resp.getWriter();
		if(!userpass.equals(password)) {
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equive='content-type' content='text/html' charset='utf-8'>");
			out.println("</head>");
			out.println("<body>alert('输入用户名或者密码有错')");
			out.println("</body>");
			out.println("</html>");
			
		}
		else {
			out.println();
		}
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	public static void main(String[] args) {
		
	}
	
	

	

}
