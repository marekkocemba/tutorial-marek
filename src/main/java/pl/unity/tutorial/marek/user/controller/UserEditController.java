/*
 * Created on 05-07-2019 14:29 by mkocemb
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

import pl.unity.tutorial.marek.user.service.command.UserEditService;
import pl.unity.tutorial.marek.user.service.command.UserForm;
import pl.unity.tutorial.marek.user.service.query.UserService;


@Controller
@RequestMapping("/users")
class UserEditController {

	public static final String P_ID = "id";
	public static final String USER_SUCCESS_VIEW = "user_success";
	public static final String USER_FORM_VIEW = "user_form";
	public static final String M_USER = "user";

	private final UserEditService userEditService;
	private final UserService userService;

	@Autowired
	private UserEditController(UserEditService userEditService, UserService userService) {

		notNull(userEditService, "UserEditService should be not null");
		notNull(userService, "UserService should be not null");

		this.userEditService = userEditService;
		this.userService = userService;

	}

	@GetMapping("/form")
	private String getNewUserForm(@RequestParam(value = "id", required = false) Long id, Model model) {

		model.addAttribute(M_USER, userService.getUserByIdIfExistOrGetNew(id));

		return USER_FORM_VIEW;
	}

	@PostMapping
	private String addUser(@Valid @ModelAttribute(M_USER) UserForm userForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return USER_FORM_VIEW;
		}
		userEditService.saveOrUpdateUser(userForm);

		return USER_SUCCESS_VIEW;
	}

	//obejscie bo nie jest obsługiwana metoda DELETE powinno byc @DeleteMapping("/{id}")
	@GetMapping("/delete/{id}")
	private String deleteBook(@PathVariable(P_ID) Long id) {

		userEditService.deleteUser(id);

		return USER_SUCCESS_VIEW;
	}
}