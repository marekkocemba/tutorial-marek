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

package pl.unity.tutorial.marek.user.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.user.model.User;


@Repository
public class UserEditRepository {

	private final SessionFactory sessionFactory;

	//TODO: przez konstruktor
	@Autowired
	public UserEditRepository(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public User saveOrUpdateUser(User user) {

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(user);
		session.flush();
		session.close();
		return user;

	}

	public void deleteUser(Long id) {

		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, id);
		session.delete(user);
		session.flush();
		session.close();
	}
}