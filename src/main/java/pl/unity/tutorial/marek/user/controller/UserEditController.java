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

import pl.unity.tutorial.marek.user.service.command.UserEditService;
import pl.unity.tutorial.marek.user.service.command.UserForm;
import pl.unity.tutorial.marek.user.service.query.UserDto;
import pl.unity.tutorial.marek.user.service.query.UserService;


@Controller
@RequestMapping("/users")
class UserEditController {

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
	private String getNewUserForm(Model model) {

		model.addAttribute("user", new UserDto());
		return "user_form";

	}

	@GetMapping("/form/{id}")
	private String getEditUserForm(@PathVariable("id") Long id, Model model) {

		model.addAttribute("user", userService.getUserById(id));
		return "user_form";

	}

	@PostMapping
	private String addUser(@Valid @ModelAttribute("user") UserForm userForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user_form";
		}
		userEditService.saveOrUpdateUser(userForm);
		return "user_success";

	}

	//obejscie bo nie jest obsługiwana metoda DELETE powinno byc @DeleteMapping("/{id}")
	@GetMapping("/delete/{id}")
	private String deleteBook(@PathVariable("id") Long id) {

		userEditService.deleteUser(id);
		return "user_success";

	}
}