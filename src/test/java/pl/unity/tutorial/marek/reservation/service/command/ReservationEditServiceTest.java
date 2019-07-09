/*
 * Created on 09-07-2019 10:13 by mkocemb
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.repository.BookEditRepository;
import pl.unity.tutorial.marek.book.repository.BookRepository;
import pl.unity.tutorial.marek.book.service.query.BookDto;
import pl.unity.tutorial.marek.reservation.model.Reservation;
import pl.unity.tutorial.marek.reservation.repository.ReservationEditRepository;
import pl.unity.tutorial.marek.reservation.repository.ReservationRepository;
import pl.unity.tutorial.marek.reservation.service.query.ReservationDto;
import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.service.query.UserService;


public class ReservationEditServiceTest {

	@InjectMocks
	private ReservationEditService reservationEditService;

	@Mock
	private ReservationEditRepository reservationEditRepository;

	@Mock
	private BookRepository bookRepository;

	@Mock
	private BookEditRepository bookEditRepository;

	@Mock
	private ReservationRepository reservationRepository;

	@Mock
	private UserService userService;

	private BookDto bookDto = new BookDto();

	private Book book = new Book();

	private User user = new User();

	private Reservation reservation = new Reservation(user, book, ZonedDateTime.now());

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		bookDto.setId(1L);
		book.setId(1L);
		user.setId(1L);
	}

	@Test
	public void addReservationByBookAndRandomUser_shouldSaveReservation() {

		//before

		when(userService.getUserRandom()).thenReturn(user);
		when(bookRepository.getBookById(bookDto.getId())).thenReturn(book);
		when(bookEditRepository.saveOrUpdateBook(book)).thenReturn(book);
		when(reservationEditRepository.saveOrUpdateReservation(any(Reservation.class))).thenReturn(reservation);

		//when

		ReservationDto result = reservationEditService.addReservationByBookAndRandomUser(bookDto);

		//then

		assertTrue(result.getUser() != null);
		assertEquals(result.getUser().getId(), new Long(1L));
		assertTrue(result.getBook() != null);
		assertEquals(result.getBook().getId(), new Long(1L));
	}

	@Test
	public void returnReservationByBook_bookAvailabilityShouldBeTrue() {

		//before

		when(bookRepository.getBookById(bookDto.getId())).thenReturn(book);
		when(reservationRepository.getReservationByBook(any(Book.class))).thenReturn(reservation);
		when(bookEditRepository.saveOrUpdateBook(book)).thenReturn(book);
		when(reservationEditRepository.saveOrUpdateReservation(reservation)).thenReturn(reservation);

		//when

		reservationEditService.returnReservationByBook(bookDto);

		//then

		verify(bookEditRepository, times(1)).saveOrUpdateBook(book);
		verify(reservationEditRepository, times(1)).saveOrUpdateReservation(reservation);

	}
}