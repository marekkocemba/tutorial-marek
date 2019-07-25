/*
 * Created on 03-07-2019 13:34 by mkocemb
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

import static org.springframework.util.Assert.notNull;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.unity.tutorial.marek.book.service.command.BookEditService;
import pl.unity.tutorial.marek.book.service.command.BookForm;
import pl.unity.tutorial.marek.book.service.query.BookService;


@Controller
@RequestMapping("/books")
class BookEditController {

	public static final String BOOK_SUCCESS_VIEW = "book_success";
	public static final String M_BOOK = "book";
	public static final String M_BOOK_FORM = "book_form";

	private final BookEditService bookEditService;
	private final BookService bookService;

	@Autowired
	private BookEditController(BookEditService bookEditService, BookService bookService) {

		notNull(bookEditService, "BookEditService should be not null");
		notNull(bookService, "BookService should be not null");

		this.bookEditService = bookEditService;
		this.bookService = bookService;
	}

	@GetMapping("/form")
	private String getNewBookForm(@RequestParam(value = "id", required = false) Long id, Model model) {

		model.addAttribute(M_BOOK, bookService.getBookByIdIfExistOrGetNew(id));

		return M_BOOK_FORM;
	}

	@PostMapping
	private String saveOrUpdateBook(@Valid @ModelAttribute(M_BOOK) BookForm bookForm, BindingResult result) {

		if (result.hasErrors()) {
			return M_BOOK_FORM;
		}

		bookEditService.saveOrUpdateBook(bookForm);

		return BOOK_SUCCESS_VIEW;
	}

	//obejscie bo nie jest obsługiwana metoda DELETE powinno byc @DeleteMapping("/{id}")
	@GetMapping("/delete/{id}")
	private String deleteBook(@PathVariable("id") Long id) {

		bookEditService.deleteBook(id);

		return BOOK_SUCCESS_VIEW;
	}
}
