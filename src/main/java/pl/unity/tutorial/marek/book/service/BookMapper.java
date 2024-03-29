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

package pl.unity.tutorial.marek.book.service;

import org.springframework.stereotype.Component;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.service.command.BookForm;
import pl.unity.tutorial.marek.book.service.query.BookDto;


@Component
public class BookMapper {

	public Book toAvailableBook(BookForm bookform) {

		Book book = new Book(
			bookform.getTitle(),
			bookform.getAuthor(),
			bookform.getBookCategory(),
			bookform.getYear(),
			true);

		return book;
	}

	public BookDto toBookDto(Book book) {

		return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getBookCategory(), book.getYear(), book.getAvailable());
	}
}
