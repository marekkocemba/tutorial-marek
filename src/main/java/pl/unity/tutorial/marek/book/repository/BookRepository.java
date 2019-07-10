/*
 * Created on 03-07-2019 15:35 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.book.repository;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.service.query.BookQueryForm;


@Repository
public class BookRepository {

	private final SessionFactory sessionFactory;

	//TODO: wspolna klasa bazowa
	@Autowired
	BookRepository(SessionFactory sessionFactory) {

		notNull(sessionFactory, "SessionFactory should be not null");
		this.sessionFactory = sessionFactory;

	}

	public Book getBookById(Long id) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class)
			.add(Restrictions.eq("id", id));
		Book book = (Book) criteria.uniqueResult();
		session.close();

		return book;

	}

	public List<Book> getBookList(BookQueryForm bookQueryForm) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		if (bookQueryForm.getTitle() != null && !bookQueryForm.getTitle().isBlank()) {
			criteria.add(Restrictions.like("title", bookQueryForm.getTitle(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (bookQueryForm.getAuthor() != null && !bookQueryForm.getAuthor().isBlank()) {
			criteria.add(Restrictions.like("author", bookQueryForm.getAuthor(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (bookQueryForm.getYearFrom() != null) {
			criteria.add(Restrictions.ge("year", bookQueryForm.getYearFrom()));
		}
		if (bookQueryForm.getYearTo() != null) {
			criteria.add(Restrictions.le("year", bookQueryForm.getYearTo()));
		}
		if (bookQueryForm.getBookCategoryList() != null && !bookQueryForm.getBookCategoryList().isEmpty()) {
			criteria.add(Restrictions.in("bookCategory", bookQueryForm.getBookCategoryList()));
		}
		if (Boolean.TRUE.equals(bookQueryForm.getAvailable())) {
			criteria.add(Restrictions.eq("available", bookQueryForm.getAvailable()));
		}
		List<Book> bookList = criteria.list();
		session.close();

		return bookList;

	}
}