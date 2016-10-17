package hu.sol.kvki.book.service;

import hu.sol.kvki.book.bean.Book;

import java.util.List;

public interface BookService {

	public List<Book> listBooks();

	public Book getBookById(Integer id);

	public Book addBook(Book book);

	public Book updateBook(Book book);

	public void deleteBook(Book book);

}
