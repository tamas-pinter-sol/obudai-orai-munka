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
				Book book = mapBookFromRs(rs);
				books.add(book);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return books;
	}

	private Book mapBookFromRs(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setDescription(rs.getString(3));
		book.setAuthor(rs.getString(4));
		book.setPubYear(rs.getInt(5));
		return book;
	}

	@Override
	public Book getBookById(Integer id) {
		Connection con;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select id, name, description, author, pub_year "
							+ "from book where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return mapBookFromRs(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book addBook(Book book) {
		book.setId(getNextId());
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into book "
							+ "(id, name, description, author, pub_year)"
							+ " values (?, ?, ?, ?, ?)");
			ps.setInt(1, book.getId());
			ps.setString(2, book.getName());
			ps.setString(3, book.getDescription());
			ps.setString(4, book.getAuthor());
			ps.setInt(5, book.getPubYear());
			ps.executeQuery();
			return getBookById(book.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Integer getNextId() {
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select book_seq.nextval from dual");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			throw new RuntimeException("No next id found");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book updateBook(Book book) {
		Connection con;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("update book set  "
					+ "name = ?, " + "description = ?, " + "author = ?, "
					+ "pub_year = ?" + " where id = ?");
			ps.setString(1, book.getName());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getPubYear());
			ps.setInt(5, book.getId());
			ps.executeQuery();
			return getBookById(book.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub

	}

}
