/*
 * Created on 05-07-2019 13:45 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.user.service;

import org.springframework.stereotype.Component;

import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.service.command.UserForm;
import pl.unity.tutorial.marek.user.service.query.UserDto;

@Component
public class UserMapper {

	public User toUser(UserDto userDto) {

		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		user.setEmail(userDto.getEmail());
		user.setTelephone(userDto.getTelephone());

		return user;
	}

	public User toUser(UserForm userForm) {

		User user = new User();
		user.setId(userForm.getId());
		user.setName(userForm.getName());
		user.setSurname(userForm.getSurname());
		user.setEmail(userForm.getEmail());
		user.setTelephone(userForm.getTelephone());

		return user;
	}

	public UserDto toUserDto(User user) {

		return new UserDto(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getTelephone());
	}
}
