/*
 * Created on 04-07-2019 16:00 by mkocemb
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
import org.springframework.web.bind.annotation.RequestMapping;

import pl.unity.tutorial.marek.book.service.query.BookQueryForm;
import pl.unity.tutorial.marek.book.service.query.BookService;


@Controller
@RequestMapping("/books")
class BookController {

	private final BookService bookService;

	private final BookQueryValidator bookQueryValidator;

	@Autowired
	private BookController(BookService bookService, BookQueryValidator bookQueryValidator) {

		notNull(bookService, "BookService should be not null");
		notNull(bookQueryValidator, "BookQueryValidator should be not null");

		this.bookService = bookService;
		this.bookQueryValidator = bookQueryValidator;

	}

	@GetMapping("/{id}")
	private String getBookById(@PathVariable("id") Long id, Model model) {

		model.addAttribute("book", bookService.getBookById(id));

		return "book_details";

	}

	@GetMapping
	private String getBookList(@Valid @ModelAttribute("book") BookQueryForm bookQueryForm, BindingResult bindingResult, Model model) {

		if (bookQueryForm != null) {
			bookQueryValidator.validate(bookQueryForm, bindingResult);
		}

		if (bindingResult.hasErrors()) {
			return "book_list";
		}

		model.addAttribute("bookList", bookService.getBookList(bookQueryForm));

		return "book_list";

	}
}
