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

package pl.unity.tutorial.marek.book.application.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.book.infrastructure.hibernate.BookRepository;
import pl.unity.tutorial.marek.unknown.BookMapper;


@Service
public class BookListService {

	private final BookRepository bookRepository;

	@Autowired
	public BookListService(BookRepository bookRepository) {

		this.bookRepository = bookRepository;
	}

	public List<BookDto> getBookList() {

		return bookRepository.getBookList()
			.stream()
			.map(BookMapper::toBookDto)
			.collect(Collectors.toList());
	}
}
