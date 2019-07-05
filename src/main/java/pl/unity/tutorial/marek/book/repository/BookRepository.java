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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.book.model.Book;


@Repository
public class BookRepository {

	private final SessionFactory sessionFactory;

	//TODO: przez konstruktor
	@Autowired
	public BookRepository(SessionFactory sessionFactory) {

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

	public List<Book> getBookList() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		List<Book> bookList = criteria.list();
		session.close();
		return bookList;
	}
}