package hu.sol.kvki.book.service;

import hu.sol.kvki.book.dao.BookDaoImpl;

public class ServiceUtil {

	public static BookService getBookService() {
		// return new BookServiceNativeDbImpl();
		return new BookServiceHibernateImpl(new BookDaoImpl());
	}

}
