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

package pl.unity.tutorial.marek.book.service.query;

import static org.springframework.util.Assert.notNull;
import static pl.unity.tutorial.marek.book.service.BookMapper.toBookDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.repository.BookRepository;
import pl.unity.tutorial.marek.book.service.BookMapper;


@Service
public class BookService {

	private final BookRepository bookRepository;

	@Autowired
	private BookService(BookRepository bookRepository) {

		notNull(bookRepository, "bookRepository must not be null");

		this.bookRepository = bookRepository;
	}

	public BookDto getBookById(Long id) {

		Book book = bookRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("No Book found by given id: " + id));
		return toBookDto(book);
	}

	public List<BookDto> getBookList(BookQueryForm bookQueryForm) {

		return bookRepository.getList(bookQueryForm)
			.stream()
			.map(BookMapper::toBookDto)
			.collect(Collectors.toList());
	}
}
