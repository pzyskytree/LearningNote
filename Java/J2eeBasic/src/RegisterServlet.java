import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse reponse) {
		
		System.out.println("Single Parameter Name: " + request.getParameter("name"));
		
		String[] hobits = request.getParameterValues("hobits");
		System.out.println("Mutiple Parameters Hobits: " + Arrays.asList(hobits));
		
		Map<String, String[]> parameters = request.getParameterMap();
		
		Set<String> keys = parameters.keySet();
		
		for(String param : keys) {
			String[] value = parameters.get(param);
			System.out.println(param + ": " + Arrays.asList(value));
		}
	}
}
