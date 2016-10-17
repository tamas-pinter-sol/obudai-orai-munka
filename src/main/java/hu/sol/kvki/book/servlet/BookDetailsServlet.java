package hu.sol.kvki.book.servlet;

import java.io.IOException;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.service.BookService;
import hu.sol.kvki.book.service.ServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/book_details")
public class BookDetailsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BookService bookService = ServiceUtil.getBookService();
		Book book = new Book();
		if (req.getParameter("bookId") != null) {
			Integer bookId = new Integer(req.getParameter("bookId"));
			book = bookService.getBookById(bookId);
		}
		req.setAttribute("book", book);

		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/book_details.jsp");
		requestDispatcher.forward(req, resp);
	}

}
