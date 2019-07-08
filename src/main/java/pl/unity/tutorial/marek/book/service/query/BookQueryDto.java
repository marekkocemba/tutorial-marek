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

import javax.validation.constraints.Min;

import pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum;


public class BookQueryDto {


	private String title;

	private String author;

	private List<BookCategoryEnum> bookCategoryList;

	@Min(0)
	private Integer yearFrom;

	@Min(0)
	private Integer yearTo;

	private Boolean available;

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

	public List<BookCategoryEnum> getBookCategoryList() {

		return bookCategoryList;
	}

	public void setBookCategoryList(List<BookCategoryEnum> bookCategoryList) {

		this.bookCategoryList = bookCategoryList;
	}

	public Integer getYearFrom() {

		return yearFrom;
	}

	public void setYearFrom(Integer yearFrom) {

		this.yearFrom = yearFrom;
	}

	public Integer getYearTo() {

		return yearTo;
	}

	public void setYearTo(Integer yearTo) {

		this.yearTo = yearTo;
	}

	public Boolean getAvailable() {

		return available;
	}

	public void setAvailable(Boolean available) {

		this.available = available;
	}
}
