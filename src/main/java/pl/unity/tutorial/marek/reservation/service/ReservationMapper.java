/*
 * Created on 03-07-2019 16:24 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.reservation.service;

import static org.springframework.util.Assert.notNull;

import org.springframework.stereotype.Component;

import pl.unity.tutorial.marek.book.service.BookMapper;
import pl.unity.tutorial.marek.reservation.model.Reservation;
import pl.unity.tutorial.marek.reservation.service.query.ReservationDto;
import pl.unity.tutorial.marek.user.service.UserMapper;


@Component
public class ReservationMapper {

	private final BookMapper bookMapper;
	private final UserMapper userMapper;

	public ReservationMapper(BookMapper bookMapper, UserMapper userMapper) {

		notNull(bookMapper, "bookMapper must not be null");
		notNull(userMapper, "userMapper must not be null");

		this.bookMapper = bookMapper;
		this.userMapper = userMapper;
	}

	public ReservationDto toReservationDto(Reservation reservation) {

		return new ReservationDto(
			reservation.getId(),
			reservation.getDateReservationStart(),
			reservation.getDateReservationEnd(),
			reservation.getUser() != null ? userMapper.toUserDto(reservation.getUser()) : null,
			reservation.getBook() != null ? bookMapper.toBookDto(reservation.getBook()) : null
		);
	}
}