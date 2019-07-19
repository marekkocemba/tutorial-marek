/*
 * Created on 08-07-2019 10:09 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.reservation.model;

import static org.springframework.util.Assert.notNull;

import java.time.ZonedDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.user.model.User;


@Entity
@Table(name = "reservations")
@Access(AccessType.FIELD)
public class Reservation {

	protected Reservation() {

	}

	public Reservation(User user, Book book, ZonedDateTime dateReservationStart) {

		notNull(user, "User should be not null");
		notNull(book, "Book should be not null");

		this.user = user;
		this.book = book;
		this.dateReservationStart = dateReservationStart;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date_reservation_start")
	private ZonedDateTime dateReservationStart;
	@Column(name = "date_reservation_end")
	private ZonedDateTime dateReservationEnd;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;

	public Long getId() {

		return id;
	}

	public ZonedDateTime getDateReservationStart() {

		return dateReservationStart;
	}

	public ZonedDateTime getDateReservationEnd() {

		return dateReservationEnd;
	}

	public User getUser() {

		return user;
	}

	public Book getBook() {

		return book;
	}

	public void setDateReservationEnd(ZonedDateTime dateReservationEnd) {
		this.dateReservationEnd = 	dateReservationEnd;
	}
}
