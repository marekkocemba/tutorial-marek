/*
 * Created on 03-07-2019 15:35 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.book.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.common.repository.AbstractRepository;


@Repository
public class BookEditRepository extends AbstractRepository<Book> {

	@Autowired
	public BookEditRepository(EntityManager entityManager) {

		super(entityManager, Book.class);
	}
}