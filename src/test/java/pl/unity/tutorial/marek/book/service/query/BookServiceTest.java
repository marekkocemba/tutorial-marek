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

package pl.unity.tutorial.marek.book.service.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum.OPOWIADANIE;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.repository.BookRepository;


public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	private Book book = new Book();

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		book.setId(1L);
		book.setTitle("testTitle");
		book.setAuthor("testAuthor");
		book.setBookCategory(OPOWIADANIE);
		book.setYear(2019);
		book.setAvailable(true);

	}

	@Test
	public void getBookById_shouldReturnBookById() {

		//before

		when(bookRepository.getBookById(1L)).thenReturn(book);

		//when

		BookDto result = bookService.getBookById(1L);

		//then

		//assertEquals(result.getId(),1L);
		assertEquals(result.getTitle(), "testTitle");
		assertEquals(result.getAuthor(), "testAuthor");
		assertEquals(result.getBookCategory(), OPOWIADANIE);
		assertTrue(result.getAvailable());
	}

	//	@Test
	//	public void deleteBook_shouldDeleteBook() {
	//
	//		//when
	//
	//		bookEditService.deleteBook(1L);
	//
	//		//then
	//
	//		verify(bookEditRepository, times(1)).deleteBook(1L);
	//	}
}
