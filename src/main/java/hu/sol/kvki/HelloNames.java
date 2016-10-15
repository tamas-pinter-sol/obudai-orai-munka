package hu.sol.kvki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloNames")
public class HelloNames extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<String> names = new ArrayList<String>();
		names.add("József");
		names.add("Sándor");
		names.add("Benedek");
		req.setAttribute("names", names);
		RequestDispatcher requestDispatcher = req.getServletContext()
				.getRequestDispatcher("/hello_names.jsp");
		requestDispatcher.forward(req, resp);
	}

}
