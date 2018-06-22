
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet{

	public void init(ServletConfig config) {
		System.out.println("HelloServlet init");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> headerNames = request.getHeaderNames();//Get Information about browser
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			System.out.printf("%s\t%s\n", name, value);
		}
		
		try {
			response.setDateHeader("Expires", 0);
			response.setHeader("Cache-Control", "no-cache");//Set Cache
			response.setHeader("pragma", "no-cache");
			
			
			response.setContentType("text/html; charset=UTF-8");
//			response.setCharacterEncoding("UTF-8");//The content sent to browser is UTF-8 but don't set the
			//charset of browser
			response.getWriter().println("<h1>你好，Hello Servlet</h1>");
			response.getWriter().write(new Date().toLocaleString());
//			response.setContentType("html/lol");//Save Dialog since lol does not exist
//			response.getWriter().append("Hello");
//			response.getWriter().format(format, args);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
