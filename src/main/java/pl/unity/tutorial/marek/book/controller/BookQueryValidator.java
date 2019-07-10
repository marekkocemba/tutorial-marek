/*
 * Created on 10-07-2019 11:21 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.book.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.unity.tutorial.marek.book.service.query.BookQueryForm;


@Component
public class BookQueryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return BookQueryForm.class.equals(clazz);

	}

	@Override
	public void validate(Object object, Errors errors) {

		BookQueryForm bookQuery = (BookQueryForm) object;
		if (isYearFromAfterYearTo(bookQuery)) {
			errors.rejectValue("yearFrom", null, "should be before or equal to yearTo");
		}

	}

	private boolean isYearFromAfterYearTo(BookQueryForm bookQuery) {

		return bookQuery.getYearFrom() != null &&
			bookQuery.getYearTo() != null &&
			bookQuery.getYearFrom() > bookQuery.getYearTo();

	}
}
