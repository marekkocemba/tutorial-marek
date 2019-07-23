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

import java.util.List;

import pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum;


public class BookQueryForm {

	private String title;
	private String author;
	private List<BookCategoryEnum> bookCategoryList;
	private Integer yearFrom;
	private Integer yearTo;
	private Boolean available;

	public String getTitle() {

		return title;
	}

	public String getAuthor() {

		return author;
	}

	public List<BookCategoryEnum> getBookCategoryList() {

		return bookCategoryList;
	}

	public Integer getYearFrom() {

		return yearFrom;
	}

	public Integer getYearTo() {

		return yearTo;
	}

	public Boolean getAvailable() {

		return available;
	}
}
