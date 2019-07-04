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

package pl.unity.tutorial.marek.service;

import static pl.unity.tutorial.marek.mapper.BookMapper.toBook;
import static pl.unity.tutorial.marek.mapper.BookMapper.toBookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.dao.BookDao;
import pl.unity.tutorial.marek.dto.BookDto;
import pl.unity.tutorial.marek.model.Book;


@Service
public class BookService {

	private final BookDao bookDao;

	@Autowired
	public BookService(BookDao bookDao){
		this.bookDao = bookDao;
	}

	public BookDto addBook(BookDto bookDto) {
		Book persistedBook = bookDao.addBook(toBook(bookDto));
		return toBookDto(persistedBook);
	}
}
