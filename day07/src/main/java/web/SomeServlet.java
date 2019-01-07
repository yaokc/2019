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
		//获得session对象	
		HttpSession session=request.getSession();
		//设置两次最大请求之间的最大间隔时间
//		session.setMaxInactiveInterval(30);
		//获得session的id
		String id=session.getId();
//		System.out.println(id);
		
		Integer count=(Integer)session.getAttribute("count");
		if(count==null){
			//第1次访问在session对象上绑定次数1
			count=1;
		}else{
			//不会是第1次将访问次数加1
			count++;
		}
		//将访问次数绑定到session对象上
		session.setAttribute("count", count);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.println("你是第"+count+"次访问");
		
		//删除session
//		session.invalidate();
	
	}
	
}
