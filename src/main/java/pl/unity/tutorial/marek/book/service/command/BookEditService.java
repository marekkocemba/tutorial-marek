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

import static pl.unity.tutorial.marek.book.service.BookMapper.toBook;
import static pl.unity.tutorial.marek.book.service.BookMapper.toBookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.repository.BookEditRepository;
import pl.unity.tutorial.marek.book.service.query.BookDto;


@Service
public class BookEditService {

	private final BookEditRepository bookEditRepository;

	@Autowired
	public BookEditService(BookEditRepository bookEditRepository) {

		this.bookEditRepository = bookEditRepository;
	}

	public BookDto saveOrUpdateBook(BookForm bookForm) {
		if(bookForm.getAvailable() == null){
			bookForm.setAvailable(true);
		}
		Book persistedBook = bookEditRepository.saveOrUpdateBook(toBook(bookForm));
		return toBookDto(persistedBook);
	}

	public void deleteBook(Long id) {

		bookEditRepository.deleteBook(id);
	}
}
