/*
 * Created on 04-07-2019 15:53 by mkocemb
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
import org.springframework.web.bind.annotation.RequestMapping;

import pl.unity.tutorial.marek.book.application.query.BookListService;


@Controller
@RequestMapping("/book-list")
class BookListController {

	private final BookListService bookListService;

	@Autowired
	private BookListController(BookListService bookListService) {

		this.bookListService = bookListService;
	}

	@GetMapping
	private String getBookList(Model model) {

		model.addAttribute("bookList", bookListService.getBookList());
		return "book_list";
	}
}
