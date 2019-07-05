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

package pl.unity.tutorial.marek.unknown.config.initial.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import pl.unity.tutorial.marek.unknown.BookCategoryEnum;
import pl.unity.tutorial.marek.book.domain.Book;
import pl.unity.tutorial.marek.book.infrastructure.hibernate.BookRepository;


@Configuration
public class InitialData {

	private final BookRepository bookRepository;

	@Autowired
	public InitialData(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}

	@PostConstruct
	public void setBooks(){
		Book book1 = new Book();
		book1.setTitle("W poszukiwaniu straconego czasu");
		book1.setAuthor("Marcel Proust");
		book1.setBookCategory(BookCategoryEnum.OPOWIADANIE);
		book1.setYear(1927);

		Book book2 = new Book();
		book2.setTitle("Poradnik domowy");
		book2.setAuthor("Prusziński");
		book2.setBookCategory(BookCategoryEnum.PORADNIK);
		book2.setYear(1995);

		Book book3 = new Book();
		book3.setTitle("Bomba megabitowa");
		book3.setAuthor("Stanisław Lem");
		book3.setBookCategory(BookCategoryEnum.OPOWIADANIE);
		book3.setYear(1999);

		bookRepository.addBook(book1);
		bookRepository.addBook(book2);
		bookRepository.addBook(book3);
	}
}
