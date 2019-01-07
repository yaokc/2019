package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���session����	
		HttpSession session=request.getSession();
		//���������������֮��������ʱ��
//		session.setMaxInactiveInterval(30);
		//���session��id
		String id=session.getId();
//		System.out.println(id);
		
		Integer count=(Integer)session.getAttribute("count");
		if(count==null){
			//��1�η�����session�����ϰ󶨴���1
			count=1;
		}else{
			//�����ǵ�1�ν����ʴ�����1
			count++;
		}
		//�����ʴ����󶨵�session������
		session.setAttribute("count", count);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.println("���ǵ�"+count+"�η���");
		
		//ɾ��session
//		session.invalidate();
	
	}
	
}
