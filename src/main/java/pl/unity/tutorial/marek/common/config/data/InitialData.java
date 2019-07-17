/*
 * Created on 04-07-2019 10:16 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.common.config.data;

import static org.springframework.util.Assert.notNull;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum;
import pl.unity.tutorial.marek.book.repository.BookEditRepository;
import pl.unity.tutorial.marek.user.model.User;
import pl.unity.tutorial.marek.user.repository.UserEditRepository;


@Configuration
public class InitialData {

	private final BookEditRepository bookEditRepository;
	private final UserEditRepository userEditRepository;

	@Autowired
	public InitialData(BookEditRepository bookEditRepository, UserEditRepository userEditRepository) {

		notNull(bookEditRepository, "BookEditRepository should be not null");
		notNull(userEditRepository, "UserEditRepository should be not null");

		this.bookEditRepository = bookEditRepository;
		this.userEditRepository = userEditRepository;

	}

	@PostConstruct
	public void setObjects() {

		setBooks();
		setUsers();

	}

	public void setBooks() {

		Book book1 = new Book();
		book1.setTitle("W poszukiwaniu straconego czasu");
		book1.setAuthor("Marcel Proust");
		book1.setBookCategory(BookCategoryEnum.OPOWIADANIE);
		book1.setYear(1927);
		book1.setAvailable(true);

		Book book2 = new Book();
		book2.setTitle("Poradnik domowy");
		book2.setAuthor("Prusziński");
		book2.setBookCategory(BookCategoryEnum.PORADNIK);
		book2.setYear(1995);
		book2.setAvailable(true);

		Book book3 = new Book();
		book3.setTitle("Bomba megabitowa");
		book3.setAuthor("Stanisław Lem");
		book3.setBookCategory(BookCategoryEnum.OPOWIADANIE);
		book3.setYear(1999);
		book3.setAvailable(true);

		bookEditRepository.saveOrUpdateBook(book1);
		bookEditRepository.saveOrUpdateBook(book2);
		bookEditRepository.saveOrUpdateBook(book3);

	}

	private void setUsers() {

		User user1 = new User();
		user1.setName("Zenon");
		user1.setSurname("Martyniuk");
		user1.setTelephone("993-456-456");
		user1.setEmail("zmart@gmail.com");

		User user2 = new User();
		user2.setName("Tomasz");
		user2.setSurname("Kasprzak");
		user2.setTelephone("44-34993-456-456");
		user2.setEmail("kasprzak@gmail.com");

		userEditRepository.saveOrUpdateUser(user1);
		userEditRepository.saveOrUpdateUser(user2);

	}
}
