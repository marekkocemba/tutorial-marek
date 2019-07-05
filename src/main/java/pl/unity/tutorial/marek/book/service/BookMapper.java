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

import pl.unity.tutorial.marek.book.service.command.BookForm;
import pl.unity.tutorial.marek.book.service.query.BookDto;
import pl.unity.tutorial.marek.book.model.Book;


public class BookMapper {

	public static Book toBook(BookDto bookDto) {

		Book book = new Book();
		book.setId(bookDto.getId());
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setBookCategory(bookDto.getBookCategory());
		book.setYear(bookDto.getYear());
		return book;
	}
	public static Book toBook(BookForm bookform) {

		Book book = new Book();
		book.setId(bookform.getId());
		book.setTitle(bookform.getTitle());
		book.setAuthor(bookform.getAuthor());
		book.setBookCategory(bookform.getBookCategory());
		book.setYear(bookform.getYear());
		return book;
	}
	public static BookDto toBookDto(Book book) {

		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setTitle(book.getTitle());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setBookCategory(book.getBookCategory());
		bookDto.setYear(book.getYear());
		return bookDto;
	}
}