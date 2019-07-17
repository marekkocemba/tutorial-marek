/*
 * Created on 09-07-2019 10:13 by mkocemb
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.repository.UserRepository;


public class UserServiceTest {

	@InjectMocks
	private UserService bookService;

	@Mock
	private UserRepository userRepository;

	private User user = new User();

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		user.setId(1L);
		user.setName("testName");
		user.setSurname("testSurname");
		user.setEmail("test@gmail.com");
		user.setTelephone("000 000");

	}

	@Test
	public void getUserById_shouldReturnUserById() {

		//before

		when(userRepository.findUserById(1L)).thenReturn(Optional.of(user));

		//when

		UserDto result = bookService.getUserById(1L);

		//then

		assertEquals(result.getId(), new Long(1));
		assertEquals(result.getName(), "testName");
		assertEquals(result.getSurname(), "testSurname");
		assertEquals(result.getEmail(), "test@gmail.com");
		assertEquals(result.getTelephone(), "000 000");

	}

	@Test
	public void getUserList_shouldReturnUserList() {

		//before

		when(userRepository.getUserList()).thenReturn(Arrays.asList(user));

		//when

		List<UserDto> resultList = bookService.getUserList();

		//then

		assertTrue(resultList.size() == 1);
		UserDto result = resultList.get(0);
		assertEquals(result.getId(), new Long(1));
		assertEquals(result.getName(), "testName");
		assertEquals(result.getSurname(), "testSurname");
		assertEquals(result.getEmail(), "test@gmail.com");
		assertEquals(result.getTelephone(), "000 000");

	}

	@Test
	public void getUserRandom_shouldReturnUser() {

		//before

		when(userRepository.getUserList()).thenReturn(Arrays.asList(user));

		//when

		User result = bookService.getUserRandom();

		//then

		assertEquals(result.getId(), new Long(1));
		assertEquals(result.getName(), "testName");
		assertEquals(result.getSurname(), "testSurname");
		assertEquals(result.getEmail(), "test@gmail.com");
		assertEquals(result.getTelephone(), "000 000");

	}
}
