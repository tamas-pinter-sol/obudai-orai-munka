package hu.sol.kvki.book.servlet;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.service.BookService;
import hu.sol.kvki.book.service.ServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/book_list")
public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BookService bookService = ServiceUtil.getBookService();
		req.setAttribute("books", bookService.listBooks());
		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/book_list.jsp");
		requestDispatcher.forward(req, resp);

	}

}
