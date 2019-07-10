/*
 * Created on 08-07-2019 09:21 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.reservation.service.command;

import static org.springframework.util.Assert.notNull;
import static pl.unity.tutorial.marek.reservation.service.ReservationMapper.toReservationDto;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.repository.BookEditRepository;
import pl.unity.tutorial.marek.book.repository.BookRepository;
import pl.unity.tutorial.marek.reservation.model.Reservation;
import pl.unity.tutorial.marek.reservation.repository.ReservationEditRepository;
import pl.unity.tutorial.marek.reservation.repository.ReservationRepository;
import pl.unity.tutorial.marek.reservation.service.query.ReservationDto;
import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.service.query.UserService;


@Service
public class ReservationEditService {

	private final ReservationEditRepository reservationEditRepository;

	private final ReservationRepository reservationRepository;

	private final UserService userService;

	private final BookRepository bookRepository;

	private final BookEditRepository bookEditRepository;

	@Autowired
	public ReservationEditService(ReservationEditRepository reservationEditRepository,
		ReservationRepository reservationRepository, UserService userService,
		BookRepository bookRepository, BookEditRepository bookEditRepository) {

		notNull(reservationEditRepository, "ReservationEditRepository should be not null");
		notNull(reservationRepository, "ReservationRepository should be not null");
		notNull(reservationEditRepository, "SessionFactory should be not null");
		notNull(bookRepository, "BookRepository should be not null");
		notNull(bookEditRepository, "BookEditRepository should be not null");

		this.reservationEditRepository = reservationEditRepository;
		this.reservationRepository = reservationRepository;
		this.userService = userService;
		this.bookRepository = bookRepository;
		this.bookEditRepository = bookEditRepository;

	}

	public ReservationDto addReservationByBookAndRandomUser(Long bookId) {

		User randomUser = userService.getUserRandom();
		Book book = bookRepository.getBookById(bookId);
		book.setAvailable(false);
		bookEditRepository.saveOrUpdateBook(book);
		Reservation persistedReservation = reservationEditRepository.saveOrUpdateReservation(
			new Reservation(randomUser, book, ZonedDateTime.now()));
		return toReservationDto(persistedReservation);

	}

	public void returnReservationByBook(Long bookId) {

		Book book = bookRepository.getBookById(bookId);
		book.setAvailable(true);

		Reservation reservation = reservationRepository.getReservationByBook(book);
		reservation.setDateReservationEnd(ZonedDateTime.now());

		bookEditRepository.saveOrUpdateBook(book);
		reservationEditRepository.saveOrUpdateReservation(reservation);

	}
}
