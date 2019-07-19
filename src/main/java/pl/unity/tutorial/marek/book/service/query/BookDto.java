/*
 * Created on 03-07-2019 14:18 by mkocemb
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

import pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum;


public class BookDto {

	private final Long id;
	private final String title;
	private final String author;
	private final BookCategoryEnum bookCategory;
	private final Integer year;
	private final Boolean available;

	public BookDto() {

		this.id = null;
		this.title = null;
		this.author = null;
		this.bookCategory = null;
		this.year = null;
		this.available = null;
	}

	public BookDto(Long id, String title, String author, BookCategoryEnum bookCategory, Integer year, Boolean available) {

		this.id = id;
		this.title = title;
		this.author = author;
		this.bookCategory = bookCategory;
		this.year = year;
		this.available = available;
	}

	public Long getId() {

		return id;
	}

	public String getTitle() {

		return title;
	}

	public String getAuthor() {

		return author;
	}

	public BookCategoryEnum getBookCategory() {

		return bookCategory;
	}

	public Integer getYear() {

		return year;
	}

	public Boolean getAvailable() {

		return available;
	}
}
