package hu.sol.kvki.book.service;

public class ServiceUtil {

	public static BookService getBookService() {
		return new BookServiceNativeDbImpl();
	}

}
