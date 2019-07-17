/*
 * Created on 03-07-2019 14:05 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.user.service.command;

import static org.springframework.util.Assert.notNull;
import static pl.unity.tutorial.marek.user.service.UserMapper.toUser;
import static pl.unity.tutorial.marek.user.service.UserMapper.toUserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.repository.UserEditRepository;
import pl.unity.tutorial.marek.user.repository.UserRepository;
import pl.unity.tutorial.marek.user.service.query.UserDto;


@Service
public class UserEditService {

	private final UserEditRepository userEditRepository;
	private final UserRepository userRepository;

	@Autowired
	public UserEditService(UserEditRepository userEditRepository, UserRepository userRepository) {

		notNull(userEditRepository, "UserEditRepository should be not null");
		notNull(userRepository, "UserRepository should be not null");

		this.userRepository = userRepository;
		this.userEditRepository = userEditRepository;

	}

	public UserDto saveOrUpdateUser(UserForm userForm) {

		User persistedUser = userEditRepository.saveOrUpdateUser(toUser(userForm));
		return toUserDto(persistedUser);

	}

	public void deleteUser(Long id) {

		User user = userRepository.findUserById(id)
			.orElseThrow(() -> new RuntimeException("No user found by id: " + id));
		userEditRepository.deleteUser(user);

	}
}
