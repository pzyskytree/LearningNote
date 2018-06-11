import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException{
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("name: " + name);
		System.out.println("password: " +  password);
		String html = null;
		if ("admin".equals(name) && "1234".equals(password))
			html = "<div style='color:green'>Success</div>";
		else
			html = "<div style='color:red'>Fail</div>";
		PrintWriter pw = response.getWriter();
		pw.println(html);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, 
	IOException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		byte[] bytes = name.getBytes("ISO-8859-1");
		name = new String(bytes, "UTF-8");
		System.out.println(name + password);
		String html = null;
		if ("admin".equals(name) && "123".equals(password))
			html = "<div style='color:green'>Success 登录成功</div>";
		else
			html = "<div style='color:red'>Fail 登录失败</div>";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(html);
	}
}
