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

package pl.unity.tutorial.marek.reservation.service.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.reservation.model.Reservation;
import pl.unity.tutorial.marek.reservation.repository.ReservationRepository;
import pl.unity.tutorial.marek.user.model.User;


public class ReservationServiceTest {

	@InjectMocks
	private ReservationService reservationService;

	@Mock
	private ReservationRepository reservationRepository;

	private Reservation reservation;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		User user = new User();
		user.setId(1L);
		Book book = new Book();
		book.setId(1L);
		reservation = new Reservation(user, book, null);

	}

	@Test
	public void getReservationsWhereBooksNotReturned_() {

		//before

		when(reservationRepository.getReservationList()).thenReturn(Arrays.asList(reservation));

		//when

		List<ReservationDto> resultList = reservationService.getReservationsWhereBooksNotReturned();

		//then

		assertTrue(resultList.size() == 1);
		ReservationDto result = resultList.get(0);
		assertTrue(result.getBook() != null);
		assertEquals(result.getBook().getId(), new Long(1));
		assertTrue(result.getUser() != null);
		assertEquals(result.getUser().getId(), new Long(1));

	}
}