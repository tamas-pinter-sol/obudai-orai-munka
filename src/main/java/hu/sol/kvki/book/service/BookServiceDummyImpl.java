package hu.sol.kvki.book.service;

import hu.sol.kvki.book.bean.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceDummyImpl implements BookService {

	private static List<Book> bookList;

	static {
		init();
	}

	private static void init() {
		bookList = new ArrayList<Book>();
		for (int i = 0; i < 20; i++) {
			Book temp = new Book();
			temp.setId(i + 1);
			temp.setName(i + 1 + ". cím");
			temp.setDescription(i + 1 + ". című könyv leírása");
			temp.setAuthor(i + 1 + ". szerző");
			temp.setPubYear(2000 + i);
			bookList.add(temp);
		}
	}

	public synchronized List<Book> listBooks() {
		return bookList;
	}

	public synchronized Book getBookById(Integer id) {
		for (Book book : bookList) {
			if (book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}

	public synchronized Book addBook(Book book) {
		book.setId(getNextId());
		bookList.add(book);
		return book;
	}

	public synchronized Book updateBook(Book book) {

		System.out.println(book.getId());
		Book bookById = getBookById(book.getId());
		deleteBook(bookById);
		bookList.add(book);
		return book;
	}

	public synchronized void deleteBook(Book book) {
		Book toBeRemove = null;
		for (Book b : bookList) {
			if (book.getId().equals(b.getId())) {
				toBeRemove = b;
			}
		}
		System.out.println("toBeRemove" + toBeRemove);
		if (toBeRemove != null) {
			bookList.remove(toBeRemove);
		}
	}

	public synchronized Integer getNextId() {
		if (bookList.size() == 0) {
			return 1;
		}
		int max = 0;
		for (Book b : bookList) {
			if (b.getId() > max) {
				max = b.getId();
			}
		}
		return max + 1;
	}
}
