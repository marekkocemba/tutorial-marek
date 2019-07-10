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

package pl.unity.tutorial.marek.user.service.query;

import static org.springframework.util.Assert.notNull;
import static pl.unity.tutorial.marek.user.service.UserMapper.toUserDto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.repository.UserRepository;
import pl.unity.tutorial.marek.user.service.UserMapper;


@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {

		notNull(userRepository, "UserRepository should be not null");
		this.userRepository = userRepository;

	}

	public UserDto getUserById(Long id) {

		User user = userRepository.getUserById(id);
		return toUserDto(user);

	}

	public List<UserDto> getUserList() {

		return userRepository.getUserList()
			.stream()
			.map(UserMapper::toUserDto)
			.collect(Collectors.toList());

	}

	public User getUserRandom() {

		Random randomGenerator = new Random();
		List<User> userList = userRepository.getUserList();
		return userList.get(randomGenerator.nextInt(userList.size()));

	}
}
