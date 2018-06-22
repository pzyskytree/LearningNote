import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

@SuppressWarnings("serial")
public class HeroAddServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Hero hero = new Hero();
		hero.setName(request.getParameter("name"));
		hero.setHp(Float.parseFloat(request.getParameter("hp")));
		hero.setDamage(Integer.parseInt(request.getParameter("damage")));
		new HeroDAO().add(hero);
//		request.getRequestDispatcher("/listHero").forward(request, response);
		response.sendRedirect("/J2eeDynamic/listHero");
	}
}
