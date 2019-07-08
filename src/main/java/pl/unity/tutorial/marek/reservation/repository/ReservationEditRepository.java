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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.reservation.model.Reservation;


@Repository
public class ReservationEditRepository {

	private final SessionFactory sessionFactory;

	@Autowired
	public ReservationEditRepository(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public Reservation saveReservation(Reservation reservation) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(reservation);
		session.flush();
		session.close();
		return reservation;
	}

	public void deleteReservation(Long reservationId) {
		Session session = sessionFactory.openSession();
		Reservation reservation = session.load(Reservation.class,reservationId);
		session.delete(reservation);
		session.flush();
		session.close();
	}
}
