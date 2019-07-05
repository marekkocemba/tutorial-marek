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

package pl.unity.tutorial.marek.book.interfaces.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.unity.tutorial.marek.book.application.query.BookSingleService;


@Controller
@RequestMapping("/books")
public class BookSingleController {

	private final BookSingleService bookSingleService;

	@Autowired
	private BookSingleController(BookSingleService bookSingleService) {

		this.bookSingleService = bookSingleService;
	}

	@GetMapping("/{id}")
	private String getBookById(@PathVariable("id") Long id, Model model) {

		model.addAttribute("book", bookSingleService.getBookById(id));
		return "book_details";
	}
}
