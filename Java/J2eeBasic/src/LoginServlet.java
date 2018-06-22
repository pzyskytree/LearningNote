import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	//Singleton Call when we try to visit the /login page
	public LoginServlet() {
		System.out.println("The LoginServlet Constructor is called");
	}
	
	public void init() {
		System.out.println("The init method is called");
	}
	
	public void destroy() {
		System.out.println("The detroy method is called");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		System.out.println("name:" + name);
//		System.out.println("password:" + password);
		String html = null;
		if ("admin".equals(name) && "1234".equals(password))
			html = "<div style='color:green'>Success</div>";
		else
			html = "<div style='color:red'>Fail</div>";
		try {
			PrintWriter pw = response.getWriter();
			pw.println(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//First execute service method
	public void service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("The service method is called");
		String name = request.getParameter("name");
		String password = request.getParameter("password");//Get parameter by name
		//Request Method
		System.out.println("Complete URL protocol host port: " + request.getRequestURL());
		System.out.println("Source except protocal and host: " + request.getRequestURI());
		System.out.println("Request parameter: " + request.getQueryString());
		System.out.println("Client IP: " + request.getRemoteAddr());
		System.out.println("Client Host: " + request.getRemoteHost());
		System.out.println("Client Port: " + request.getRemotePort());
		System.out.println("Server IP: " + request.getLocalAddr());
		System.out.println("Server Name: " + request.getLocalName());
		System.out.println("Client request method: " + request.getMethod());
		
		
		try {
			if ("admin".equals(name) && "1234".equals(password)) {
				//Service Jump: not change the path /login
				request.getRequestDispatcher("success.html").forward(request, response);
			}else {
				//Client Jump: change to fail.html
//				response.sendRedirect("fail.html");//Tempoary Jump 302
				response.setStatus(301);
				response.setHeader("Location", "fail.html");
			}
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String html = null;
//		if ("admin".equals(name) && "1234".equals(password))
//			html = "<div style='color:red'>登录成功</div>";
//		else
//			html = "<div style='color:green'>登录失败</div>";
//		try {
//			response.setContentType("text/html; charset=UTF-8"); //request.getHeader("accept");
//			PrintWriter pw = response.getWriter();
//			pw.write(html);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}
	
}
