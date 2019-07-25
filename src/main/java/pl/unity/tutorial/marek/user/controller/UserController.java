/*
 * Created on 05-07-2019 13:09 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.user.controller;

import static org.springframework.util.Assert.notNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.unity.tutorial.marek.user.service.query.UserService;


@Controller
@RequestMapping("/users")
class UserController {

	public static final String USER_LIST_VIEW = "user_list";
	public static final String M_USER_LIST = "userList";
	public static final String USER_DETAILS_VIEW = "user_details";
	public static final String M_USER = "user";

	private final UserService userService;

	@Autowired
	private UserController(UserService userService) {

		notNull(userService, "UserService should be not null");

		this.userService = userService;
	}

	@GetMapping("/{id}")
	private String getUserById(@PathVariable("id") Long id, Model model) {

		model.addAttribute(M_USER, userService.getUserById(id));

		return USER_DETAILS_VIEW;
	}

	@GetMapping
	private String getUserList(Model model) {

		model.addAttribute(M_USER_LIST, userService.getUserList());

		return USER_LIST_VIEW;
	}
}
