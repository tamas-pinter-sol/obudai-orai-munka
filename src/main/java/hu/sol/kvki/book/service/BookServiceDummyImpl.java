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
			temp.setDesc(i + 1 + ". című könyv leírása");
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

	public synchronized void addBook(Book book) {
		bookList.add(book);
	}

	public synchronized void updateBook(Book book) {
		Book bookById = getBookById(book.getId());
		deleteBook(bookById);
		bookList.add(book);
	}

	public synchronized void deleteBook(Book book) {
		Book toBeRemove = null;
		for (Book b : bookList) {
			if (book.getId().equals(book.getId())) {
				toBeRemove = b;
			}
		}
		if(toBeRemove != null){
			bookList.remove(toBeRemove);
		}
	}

	public Integer getNextId() {
		if(bookList.size() == 0){
			return 1;
		}
		int max = 0;
		for(Book b: bookList){
			if(b.getId() > max){
				max = b.getId();
			}
		}
		return max;
	}
}
