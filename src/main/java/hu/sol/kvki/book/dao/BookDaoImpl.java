package hu.sol.kvki.book.dao;

import hu.sol.kvki.book.bean.Book;
import hu.sol.kvki.book.util.HibernateUtil;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BookDaoImpl implements BookDao {

	@Override
	public Book findById(Integer id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Book book = session.get(Book.class, id);

		transaction.commit();

		session.close();

		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBookByAuthor(String author) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria crit = session.createCriteria(Book.class);
		Criterion authorCrit = Restrictions.like("author", author,
				MatchMode.ANYWHERE);

		crit.add(authorCrit);

		List<Book> books = crit.addOrder(Order.asc("name")).list();

		session.close();

		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Criteria crit = session.createCriteria(Book.class);

		List<Book> books = crit.list();

		transaction.commit();

		session.close();

		return books;
	}

	@Override
	public Integer saveBook(Book book) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Integer id = (Integer) session.save(book);

		transaction.commit();

		session.close();

		return id;
	}

	@Override
	public void updateBook(Book book) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.update(book);

		transaction.commit();
		session.close();
	}

	@Override
	public void deleteBook(Book book) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.delete(book);

		transaction.commit();
		session.close();

	}

}
