package hu.sol.kvki;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String parameter = req.getParameter("name");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("Hello " + parameter +"!<br/>");
		writer.print("<a href='javascript:window.history.back();'>Vissza</a>");
	}

	
	
}
