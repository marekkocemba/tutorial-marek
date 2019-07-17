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

package pl.unity.tutorial.marek.user.service.command;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.repository.UserEditRepository;
import pl.unity.tutorial.marek.user.repository.UserRepository;
import pl.unity.tutorial.marek.user.service.query.UserDto;


public class UserEditServiceTest {

	@InjectMocks
	private UserEditService userEditService;

	@Mock
	private UserEditRepository userEditRepository;

	@Mock
	private UserRepository userRepository;

	private UserForm userForm = new UserForm();

	private User user = new User();

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		user.setId(1L);
		user.setName("testName");
		user.setSurname("testSurname");
		user.setEmail("test@gmail.com");
		user.setTelephone("000 000");

		userForm.setId(1L);
		userForm.setName("testName");
		userForm.setSurname("testSurname");
		userForm.setEmail("test@gmail.com");
		userForm.setTelephone("000 000");
	}

	@Test
	public void saveOrUpdateUser_shouldSaveUser() {

		//before

		when(userEditRepository.saveOrUpdateUser(any(User.class))).thenReturn(user);

		//when

		UserDto result = userEditService.saveOrUpdateUser(userForm);

		//then

		assertEquals(result.getId(), new Long(1));
		assertEquals(result.getName(), "testName");
		assertEquals(result.getSurname(), "testSurname");
		assertEquals(result.getEmail(), "test@gmail.com");
		assertEquals(result.getTelephone(), "000 000");
	}

	@Test
	public void deleteBook_shouldDeleteBook() {

		//before

		when(userRepository.findUserById(1L)).thenReturn(Optional.of(user));

		//when

		userEditService.deleteUser(1L);

		//then

		verify(userEditRepository, times(1)).deleteUser(user);
	}
}
