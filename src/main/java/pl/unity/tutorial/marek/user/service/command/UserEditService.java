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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.repository.UserEditRepository;
import pl.unity.tutorial.marek.user.repository.UserRepository;
import pl.unity.tutorial.marek.user.service.UserMapper;
import pl.unity.tutorial.marek.user.service.query.UserDto;


@Service
public class UserEditService {

	private final UserEditRepository userEditRepository;
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Autowired
	private UserEditService(UserEditRepository userEditRepository, UserRepository userRepository, UserMapper userMapper) {

		notNull(userEditRepository, "UserEditRepository should be not null");
		notNull(userRepository, "UserRepository should be not null");
		notNull(userMapper, "userMapper should be not null");

		this.userRepository = userRepository;
		this.userEditRepository = userEditRepository;
		this.userMapper = userMapper;

	}

	public UserDto saveOrUpdateUser(UserForm userForm) {

		User persistedUser = userEditRepository.saveOrUpdate(userMapper.toUser(userForm));

		return userMapper.toUserDto(persistedUser);

	}

	public void deleteUser(Long id) {

		User user = userRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("No user found by id: " + id));

		userEditRepository.delete(user);

	}
}
