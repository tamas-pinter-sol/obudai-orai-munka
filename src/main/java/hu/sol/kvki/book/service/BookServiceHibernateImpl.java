package hu.sol.kvki.book.service;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.dao.BookDao;
import hu.sol.kvki.book.dao.BookDaoImpl;

import java.util.List;

public class BookServiceHibernateImpl implements BookService {

	private static BookDao bookDao;

	static {
		bookDao = new BookDaoImpl();
	}

	@Override
	public List<Book> listBooks() {
		return bookDao.listAll();
	}

	@Override
	public Book getBookById(Integer id) {
		return bookDao.findById(id);
	}

	@Override
	public Book addBook(Book book) {
		return bookDao.findById(bookDao.saveBook(book));
	}

	@Override
	public Book updateBook(Book book) {
		if (book.getId() == null) {
			throw new IllegalArgumentException("BookId cannot be null..");
		}
		bookDao.updateBook(book);
		return bookDao.findById(book.getId());
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub

	}

}
