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

import java.time.ZonedDateTime;

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
public class Reservation {

	public Reservation(){
	}

	public Reservation(User user, Book book, ZonedDateTime dateReservation){
		this.user = user;
		this.book = book;
		this.dateReservation = dateReservation;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="date_reservation")
	private ZonedDateTime dateReservation;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public ZonedDateTime getDateReservation() {

		return dateReservation;
	}

	public void setDateReservation(ZonedDateTime dateReservation) {

		this.dateReservation = dateReservation;
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public Book getBook() {

		return book;
	}

	public void setBook(Book book) {

		this.book = book;
	}
}
