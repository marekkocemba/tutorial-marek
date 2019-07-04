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

package pl.unity.tutorial.marek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.unity.tutorial.marek.dto.BookDto;
import pl.unity.tutorial.marek.service.BookService;


@Controller
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService){
		this.bookService = bookService;
	}

	@GetMapping("/new")
	public ModelAndView getNewBookForm() {
		return new ModelAndView("new_book_form", "book", new BookDto());
	}

	@PostMapping
	public String addBook(@Valid @ModelAttribute("book") BookDto bookDto, BindingResult result,  ModelMap model) {
		if (result.hasErrors()) {
			return "new_book_form";
		}
		bookService.addBook(bookDto);
		return "new_book_success";
	}
}
