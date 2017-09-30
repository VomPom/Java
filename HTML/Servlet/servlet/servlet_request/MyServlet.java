package WORK.HTML.Servlet.servlet.servlet_request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����������д���
		//���ǰ���ύ�����ݣ����������
		String username = req.getParameter("username");//���ݲ������ƻ�ò���ֵ
		String password = req.getParameter("password");
		System.out.println("��¼���˺ţ�"+username+",���룺"+password);
		
		//TODO �������ݿ�����˺ź������Ƿ���ȷ
		
		//��Ӧ����
		PrintWriter out = resp.getWriter();
		//��Ӧ�ı�����
		//out.println("success!welcome,"+username);
		//��Ӧhtml����
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equive=\"content-type\" content='text/html;charset=utf-8'>");
		out.println("<title>login success</title>");
		out.println("<script type='text/javascript' src='test.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style='color:red'>");
		out.println("success!welcome,"+username);
		out.println("</h2>");
		out.println("</body>");
		
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
