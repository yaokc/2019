package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Integer count=(Integer)session.getAttribute("count");
		
		if(count==null){
			count=1;
			out.println("第1次访问！");
		}else{
			count++;
			session.setAttribute("count", count);
			out.println("是第"+count+""+"次访问！");
		}
		
		
		
	}
}
