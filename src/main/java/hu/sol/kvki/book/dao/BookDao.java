package hu.sol.kvki.book.dao;

import java.util.List;

import hu.sol.kvki.book.bean.Book;

public interface BookDao {

	Book findById(Integer id);

	List<Book> listBookByAuthor(String author);

	List<Book> listAll();

	Integer saveBook(Book book);

	void updateBook(Book book);

	void deleteBook(Book book);
}
