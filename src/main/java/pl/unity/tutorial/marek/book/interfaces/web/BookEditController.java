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

package pl.unity.tutorial.marek.book.interfaces.web;

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

import pl.unity.tutorial.marek.book.application.command.BookEditService;
import pl.unity.tutorial.marek.book.application.command.BookForm;
import pl.unity.tutorial.marek.book.application.query.BookDto;
import pl.unity.tutorial.marek.book.application.query.BookSingleService;


@Controller
@RequestMapping("/books")
class BookEditController {

	private final BookEditService bookEditService;
	private final BookSingleService bookSingleService;

	@Autowired
	private BookEditController(BookEditService bookEditService, BookSingleService bookSingleService) {

		this.bookEditService = bookEditService;
		this.bookSingleService = bookSingleService;
	}

	@GetMapping("/form/{id}")
	private String getNewOrEditBookForm(@PathVariable(required = false, name = "id") Long id, Model model) {

		if (id != null) {
			model.addAttribute("book", bookSingleService.getBookById(id));
		}
		else {
			model.addAttribute("book", new BookDto());
		}
		return "book_form";
	}

	@PostMapping
	private String addOrEditBook(@Valid @ModelAttribute("book") BookForm bookForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "book_form";
		}
		bookEditService.addBook(bookForm);
		return "book_new_success";
	}
}
