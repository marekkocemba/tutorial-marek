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

package pl.unity.tutorial.marek.book.application.query;

import pl.unity.tutorial.marek.unknown.BookCategoryEnum;


public class BookDto {

	private Long id;

	private String title;

	private String author;

	private BookCategoryEnum bookCategory;

	private Integer year;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public String getAuthor() {

		return author;
	}

	public void setAuthor(String author) {

		this.author = author;
	}

	public BookCategoryEnum getBookCategory() {

		return bookCategory;
	}

	public void setBookCategory(BookCategoryEnum bookCategory) {

		this.bookCategory = bookCategory;
	}

	public Integer getYear() {

		return year;
	}

	public void setYear(Integer year) {

		this.year = year;
	}
}
