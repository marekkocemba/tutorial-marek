/*
 * Created on 03-07-2019 14:05 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.book.application.command;

import static pl.unity.tutorial.marek.unknown.BookMapper.toBook;
import static pl.unity.tutorial.marek.unknown.BookMapper.toBookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.book.application.query.BookDto;
import pl.unity.tutorial.marek.book.domain.Book;
import pl.unity.tutorial.marek.book.infrastructure.hibernate.BookRepository;


@Service
public class BookEditService {

	private final BookRepository bookRepository;

	@Autowired
	public BookEditService(BookRepository bookRepository) {

		this.bookRepository = bookRepository;
	}

	public BookDto addBook(BookForm bookForm) {

		Book persistedBook = bookRepository.addBook(toBook(bookForm));
		return toBookDto(persistedBook);
	}
}
