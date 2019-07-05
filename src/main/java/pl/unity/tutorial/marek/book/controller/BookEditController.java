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

import pl.unity.tutorial.marek.book.service.command.BookEditService;
import pl.unity.tutorial.marek.book.service.command.BookForm;
import pl.unity.tutorial.marek.book.service.query.BookDto;
import pl.unity.tutorial.marek.book.service.query.BookService;


@Controller
@RequestMapping("/books")
class BookEditController {

	private final BookEditService bookEditService;
	private final BookService bookService;

	@Autowired
	private BookEditController(BookEditService bookEditService, BookService bookService) {

		this.bookEditService = bookEditService;
		this.bookService = bookService;
	}

	@GetMapping("/{id}/form")
	private String getEditBookForm(@PathVariable("id") Long id, Model model) {

		model.addAttribute("book", bookService.getBookById(id));
		return "book_form_edit";
	}

	@GetMapping("/form/{id}")
	private String getBookForm(@PathVariable(required = false, name = "id") Long id, Model model) {

		if (id != null) {
			model.addAttribute("book", bookService.getBookById(id));
		}
		else {
			model.addAttribute("book", new BookDto());
		}
		return "book_form";
	}

	@PostMapping
	private String addBook(@Valid @ModelAttribute("book") BookForm bookForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "book_form";
		}
		bookEditService.saveOrUpdateBook(bookForm);
		return "book_success";
	}

	//obejscie bo nie jest obsługiwana metoda DELETE powinno byc @DeleteMapping("/{id}")
	@GetMapping("/delete/{id}")
	private String deleteBook(@PathVariable("id") Long id) {

		System.out.println("deledede");
		bookEditService.deleteBook(id);
		return "book_success";
	}
}
