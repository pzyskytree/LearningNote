import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroUpdateServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int damage = Integer.parseInt(request.getParameter("damage"));
		float hp = Float.parseFloat(request.getParameter("hp"));
		Hero hero = new Hero();
		hero.setId(id);
		hero.setHp(hp);
		hero.setName(name);
		hero.setDamage(damage);
		new HeroDAO().update(hero);
		response.sendRedirect("listHero");
	}
}
