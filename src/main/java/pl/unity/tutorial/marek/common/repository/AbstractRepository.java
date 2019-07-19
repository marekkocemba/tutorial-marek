/*
 * Created on 16-07-2019 16:32 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.common.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Transactional
@EnableTransactionManagement
public abstract class AbstractRepository<T> implements Repository {

	private final EntityManager entityManager;
	private final Class<T> entityClass;

	protected AbstractRepository(EntityManager entityManager, Class<T> entityClass) {

		Assert.notNull(entityClass, "entityClass is required");
		Assert.notNull(entityManager, "entityManager is required");

		this.entityManager = entityManager;
		this.entityClass = entityClass;
	}

	public T saveOrUpdate(T item) {

		getSession().saveOrUpdate(item);

		return item;
	}

	public void delete(T item) {

		getSession().delete(item);
	}

	public Optional<T> findById(Long id) {

		Criteria queryByField = getSession().createCriteria(entityClass)
			.add(Restrictions.eq("id", id))
			.setMaxResults(1);

		return Optional.ofNullable((T) queryByField.uniqueResult());
	}

	protected List<T> getListByCriteria(Criteria criteria) {

		return criteria.list();
	}

	protected Optional<T> findByCriteria(Criteria criteria) {

		return (Optional<T>) Optional.ofNullable(criteria.uniqueResult());
	}

	public List<T> getList() {

		Criteria queryAll = getSession().createCriteria(entityClass);

		return queryAll.list();
	}

	protected Session getSession() {

		return entityManager.unwrap(Session.class);
	}
}
