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

import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.unity.tutorial.marek.user.model.User;


@Repository
public class UserRepository {

	private final SessionFactory sessionFactory;

	@Autowired
	public UserRepository(SessionFactory sessionFactory) {

		notNull(sessionFactory, "SessionFactory should be not null");
		this.sessionFactory = sessionFactory;

	}

	public User getUserById(Long id) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class)
			.add(Restrictions.eq("id", id));
		User user = (User) criteria.uniqueResult();
		session.close();
		return user;

	}

	public List<User> getUserList() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> userList = criteria.list();
		session.close();
		return userList;

	}
}