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

package pl.unity.tutorial.marek.book.service.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum.OPOWIADANIE;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.repository.BookEditRepository;
import pl.unity.tutorial.marek.book.service.query.BookDto;


public class BookEditServiceTest {

	@InjectMocks
	private BookEditService bookEditService;

	@Mock
	private BookEditRepository bookEditRepository;

	private BookForm bookForm = new BookForm();

	private Book book = new Book();

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		bookForm.setId(1L);
		bookForm.setTitle("testTitle");
		bookForm.setAuthor("testAuthor");
		bookForm.setBookCategory(OPOWIADANIE);
		bookForm.setYear(2019);

		book.setId(1L);
		book.setTitle("testTitle");
		book.setAuthor("testAuthor");
		book.setBookCategory(OPOWIADANIE);
		book.setYear(2019);
		book.setAvailable(true);
	}

	@Test
	public void saveOrUpdateBook_shouldSaveBook() {

		//before

		when(bookEditRepository.saveOrUpdateBook(any(Book.class))).thenReturn(book);

		//when

		BookDto result = bookEditService.saveOrUpdateBook(bookForm);

		//then

		assertEquals(result.getId(), new Long(1L));
		assertEquals(result.getTitle(), "testTitle");
		assertEquals(result.getAuthor(), "testAuthor");
		assertEquals(result.getBookCategory(), OPOWIADANIE);
		assertTrue(result.getAvailable());
	}

	@Test
	public void deleteBook_shouldDeleteBook() {

		//when

		bookEditService.deleteBook(1L);

		//then

		verify(bookEditRepository, times(1)).deleteBook(1L);
	}
}
