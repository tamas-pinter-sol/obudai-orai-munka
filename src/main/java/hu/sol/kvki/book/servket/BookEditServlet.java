package hu.sol.kvki.book.servket;

import hu.sol.kvki.book.bean.Book;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = "/book_edit")
public class BookEditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book = new Book();
		book.setName("");
		book.setDesc("");
		book.setAuthor("");
		book.setPubYear(0);
		req.setAttribute("book", book);

		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/book_edit.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book = new Book();
		try {
			BeanUtils.populate(book, req.getParameterMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		req.setAttribute("book", book);

		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/book_details.jsp");
		requestDispatcher.forward(req, resp);
	}

}
