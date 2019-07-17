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

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.book.model.Book;
import pl.unity.tutorial.marek.book.service.query.BookQueryForm;
import pl.unity.tutorial.marek.common.repository.AbstractRepository;


@Repository
public class BookRepository extends AbstractRepository<Book> {

	@Autowired
	public BookRepository(EntityManager entityManager) {

		super(entityManager, Book.class);

	}

	public Optional<Book> findBookById(Long id) {

		return findById(id);

	}

	public List<Book> getBookList(BookQueryForm bookQueryForm) {

		Criteria criteria = getSession().createCriteria(Book.class);

		if (bookQueryForm.getTitle() != null && !bookQueryForm.getTitle().isBlank()) {
			criteria.add(Restrictions.like("title", bookQueryForm.getTitle(), MatchMode.ANYWHERE).ignoreCase());
		}

		if (bookQueryForm.getAuthor() != null && !bookQueryForm.getAuthor().isBlank()) {
			criteria.add(Restrictions.like("author", bookQueryForm.getAuthor(), MatchMode.ANYWHERE).ignoreCase());
		}

		if (bookQueryForm.getYearFrom() != null) {
			criteria.add(Restrictions.ge("year", bookQueryForm.getYearFrom()));
		}

		if (bookQueryForm.getYearTo() != null) {
			criteria.add(Restrictions.le("year", bookQueryForm.getYearTo()));
		}

		if (bookQueryForm.getBookCategoryList() != null && !bookQueryForm.getBookCategoryList().isEmpty()) {
			criteria.add(Restrictions.in("bookCategory", bookQueryForm.getBookCategoryList()));
		}

		if (Boolean.TRUE.equals(bookQueryForm.getAvailable())) {
			criteria.add(Restrictions.eq("available", bookQueryForm.getAvailable()));
		}

		return (List<Book>) getListByCriteria(criteria);

	}
}