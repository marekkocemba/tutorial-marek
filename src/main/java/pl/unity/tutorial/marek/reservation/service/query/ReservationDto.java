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

	private final Long id;
	private final ZonedDateTime dateReservationStart;
	private final ZonedDateTime dateReservationEnd;
	private final UserDto user;
	private final BookDto book;

	public ReservationDto(Long id, ZonedDateTime dateReservationStart, ZonedDateTime dateReservationEnd, UserDto user, BookDto book) {

		this.id = id;
		this.dateReservationStart = dateReservationStart;
		this.dateReservationEnd = dateReservationEnd;
		this.user = user;
		this.book = book;
	}

	public Long getId() {

		return id;
	}

	public UserDto getUser() {

		return user;
	}

	public BookDto getBook() {

		return book;
	}
}
