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

package pl.unity.tutorial.marek.book.service.command;

import static org.springframework.util.Assert.notNull;
import static pl.unity.tutorial.marek.book.service.BookMapper.toBook;
import static pl.unity.tutorial.marek.book.service.BookMapper.toBookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.repository.BookEditRepository;
import pl.unity.tutorial.marek.book.repository.BookRepository;
import pl.unity.tutorial.marek.book.service.query.BookDto;


@Service
public class BookEditService {

	private final BookEditRepository bookEditRepository;
	private final BookRepository bookRepository;

	@Autowired
	private BookEditService(BookEditRepository bookEditRepository, BookRepository bookRepository) {

		notNull(bookEditRepository, "BookEditRepository should be not null");
		notNull(bookRepository, "BookRepository should be not null");

		this.bookEditRepository = bookEditRepository;
		this.bookRepository = bookRepository;
	}

	public BookDto saveOrUpdateBook(BookForm bookForm) {

		//asercje nna
		notNull(bookForm, "bookForm must not be null");

		Book book = toBook(bookForm);

		book.setAvailable(true);
		bookEditRepository.saveOrUpdate(book);

		return toBookDto(book);
	}

	public void deleteBook(Long id) {

		Book book = bookRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("No book found by id: " + id));

		bookEditRepository.delete(book);
	}
}
