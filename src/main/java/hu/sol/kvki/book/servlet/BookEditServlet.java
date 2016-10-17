package hu.sol.kvki.book.servlet;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.service.BookService;
import hu.sol.kvki.book.service.ServiceUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/book_edit")
public class BookEditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BookService bookService = ServiceUtil.getBookService();
		Book book;
		if (req.getParameter("bookId") != null) {
			Integer bookId = new Integer(req.getParameter("bookId"));
			book = bookService.getBookById(bookId);
		} else {
			book = new Book();
		}
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
			if (req.getParameter("id") == null
					|| req.getParameter("id").isEmpty()) {
				book.setId(null);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		BookService bookService = ServiceUtil.getBookService();
		Book updatedBook;
		System.out.println(book.getId());
		if (book.getId() == null) {
			updatedBook = bookService.addBook(book);
		} else {
			updatedBook = bookService.updateBook(book);
		}
		req.setAttribute("book", updatedBook);

		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/book_details.jsp");
		requestDispatcher.forward(req, resp);
	}

}
