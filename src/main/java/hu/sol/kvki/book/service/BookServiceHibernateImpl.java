package hu.sol.kvki.book.service;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.dao.BookDao;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebService
@Component
public class BookServiceHibernateImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	
	public BookServiceHibernateImpl() {
	}
	
	@Autowired
	public BookServiceHibernateImpl(BookDao bookDao) {
		this.bookDao = bookDao;
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
