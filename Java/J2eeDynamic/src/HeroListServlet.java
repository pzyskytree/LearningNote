import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

@SuppressWarnings("serial")
public class HeroListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		List<Hero> list = new HeroDAO().list();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table align='center' border='1' cellspacing='0'>\n");
		sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>edit</td><td>delete</td></tr>\n");
		
		String format = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td>"
				+ "<td><a href='editHero?id=%d'>edit</a></td>"
				+ "<td><a href='deleteHero?id=%d'>delete</a></td></tr>\n";
		for (Hero h : list) {
			String str = String.format(format, h.getId(), h.getName(), h.getHp(), h.getDamage(),
					h.getId(), h.getId());
			sb.append(str);
		}
		sb.append("</table>");
		response.getWriter().write(sb.toString());
		
	}
}
