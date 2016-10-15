package hu.sol.kvki.book.servket;

import hu.sol.kvki.book.bean.Book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book = new Book();
		book.setId(1);
		book.setName("Könyv cím");
		book.setDesc("Könyv leírás");
		book.setAuthor("Könyv szerzõje");
		book.setPubYear(2000);

		req.setAttribute("book", book);

		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/book_details.jsp");
		requestDispatcher.forward(req, resp);

	}

}
