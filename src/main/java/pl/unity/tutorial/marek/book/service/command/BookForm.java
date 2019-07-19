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

package pl.unity.tutorial.marek.book.service.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum;


public class BookForm {

	private Long id;
	@NotNull
	@Size(min = 2, max = 30)
	private String title;
	@NotNull
	@Size(min = 2, max = 30)
	private String author;
	@NotNull
	private BookCategoryEnum bookCategory;
	private Integer year;
	private Boolean available;

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

	public Boolean getAvailable() {

		return available;
	}

	public void setAvailable(Boolean available) {

		this.available = available;
	}
}
