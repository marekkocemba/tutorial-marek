/*
 * Created on 03-07-2019 15:48 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.book.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum;


@Entity
@Table(name = "books")
@Access(AccessType.FIELD)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String author;

	@Enumerated(EnumType.STRING)
	@Column(name = "book_category")
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
