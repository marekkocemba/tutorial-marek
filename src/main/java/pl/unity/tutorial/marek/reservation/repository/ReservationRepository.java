/*
 * Created on 08-07-2019 09:44 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.reservation.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.reservation.model.Reservation;


@Repository
public class ReservationRepository {

	private final SessionFactory sessionFactory;

	@Autowired
	public ReservationRepository(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public Reservation getReservationByBook(Book book) {

		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("book", book));
		criteria.setMaxResults(1);
		Reservation reservation = (Reservation) criteria.uniqueResult();
		session.close();
		return reservation;
	}

	public List<Reservation> getReservationList() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.createAlias("book", "bk");
		criteria.add(Restrictions.eq("bk.available", false));
		List<Reservation> reservationList = criteria.list();
		session.close();
		return reservationList;
	}
}
