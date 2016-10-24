package hu.sol.kvki.book.service;

import hu.sol.kvki.book.bean.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookServiceNativeDbImpl implements BookService {

	private DataSource dataSource;

	public BookServiceNativeDbImpl() {
		try {
			InitialContext context = new InitialContext();
			dataSource = (DataSource) context.lookup("jdbc/bookDatasource");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Book> listBooks() {
		List<Book> books = new ArrayList<Book>();
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select id, name, description, author, pub_year from book");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setDescription(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPubYear(rs.getInt(5));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return books;
	}

	@Override
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub

	}

}
