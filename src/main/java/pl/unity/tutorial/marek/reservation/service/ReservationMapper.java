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

import static pl.unity.tutorial.marek.book.service.BookMapper.toBook;
import static pl.unity.tutorial.marek.book.service.BookMapper.toBookDto;
import static pl.unity.tutorial.marek.user.service.UserMapper.toUser;
import static pl.unity.tutorial.marek.user.service.UserMapper.toUserDto;

import pl.unity.tutorial.marek.reservation.model.Reservation;
import pl.unity.tutorial.marek.reservation.service.query.ReservationDto;


public class ReservationMapper {

	public static Reservation toReservation(ReservationDto reservationDto) {

		Reservation reservation = new Reservation();
		reservation.setId(reservationDto.getId());
		reservation.setDateReservation(reservationDto.getDateReservation());
		reservation.setBook(reservationDto.getBook() != null ? toBook(reservationDto.getBook()) : null);
		reservation.setUser(reservationDto.getUser() != null ? toUser(reservationDto.getUser()) : null);
		return reservation;
	}

	public static ReservationDto toReservationDto(Reservation reservation) {

		ReservationDto reservationDto = new ReservationDto();
		reservationDto.setId(reservation.getId());
		reservationDto.setDateReservation(reservation.getDateReservation());
		reservationDto.setBook(reservation.getBook() != null ? toBookDto(reservation.getBook()) : null);
		reservationDto.setUser(reservation.getUser() != null ? toUserDto(reservation.getUser()) : null);
		return reservationDto;
	}
}
