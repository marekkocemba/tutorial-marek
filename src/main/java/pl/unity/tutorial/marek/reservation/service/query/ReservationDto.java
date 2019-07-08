/*
 * Created on 05-07-2019 16:44 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.reservation.service.query;

import java.time.ZonedDateTime;

import pl.unity.tutorial.marek.book.service.query.BookDto;
import pl.unity.tutorial.marek.user.service.query.UserDto;


public class ReservationDto {

	private Long id;

	private ZonedDateTime dateReservationStart;

	private ZonedDateTime dateReservationEnd;

	private UserDto user;

	private BookDto book;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public UserDto getUser() {

		return user;
	}

	public void setUser(UserDto user) {

		this.user = user;
	}

	public BookDto getBook() {

		return book;
	}

	public void setBook(BookDto book) {

		this.book = book;
	}

	public ZonedDateTime getDateReservationStart() {

		return dateReservationStart;
	}

	public void setDateReservationStart(ZonedDateTime dateReservationStart) {

		this.dateReservationStart = dateReservationStart;
	}

	public ZonedDateTime getDateReservationEnd() {

		return dateReservationEnd;
	}

	public void setDateReservationEnd(ZonedDateTime dateReservationEnd) {

		this.dateReservationEnd = dateReservationEnd;
	}
}
