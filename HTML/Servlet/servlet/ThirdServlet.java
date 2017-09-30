package WORK.HTML.Servlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����httpЭ���servlet,��д��service()���������л������ķ�ʽ���ٸ�������ķ�ʽ��ͬ�����ò�ͬ�ķ���
//�����get��ʽ�����󣬵���doGet()�������post��ʽ�����󣬵���doPost()����
public class ThirdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get��ʽ������");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post��ʽ������");
	}
	
}
