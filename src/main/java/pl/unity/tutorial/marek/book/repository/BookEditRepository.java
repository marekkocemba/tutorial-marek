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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.book.model.Book;


@Repository
public class BookEditRepository {

	private final SessionFactory sessionFactory;

	@Autowired
	public BookEditRepository(SessionFactory sessionFactory) {

		notNull(sessionFactory, "SessionFactory should be not null");
		this.sessionFactory = sessionFactory;

	}

	public Book saveOrUpdateBook(Book book) {

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(book);
		session.flush();
		session.close();
		return book;

	}

	public void deleteBook(Long id) {

		Session session = sessionFactory.openSession();
		Book book = (Book)session.load(Book.class,id);
		session.delete(book);
		session.flush();
		session.close();

	}
}