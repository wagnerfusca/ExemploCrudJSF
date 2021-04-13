package br.com.aula.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.aula.dao.DAO;
import br.com.aula.model.Uf;


@Repository
@Transactional
public class UfDao implements DAO<Uf> {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public List<Uf> findAll() {
		return entityManager.createQuery("from Uf").getResultList();
	}

	@Override
	public Uf findById(Integer id) {
		Query query = entityManager.createQuery("from Uf where id = :pId");
		query.setParameter("pId", id);
		return (Uf) query.getSingleResult();
	}

	@Override
	public List<Uf> findByName(String name) {
		Query query = entityManager.createQuery("from Uf where nome like :pNome");
		query.setParameter("pNome", "%" + name + "%");
		return query.getResultList();
	}

	public boolean save(Uf uf) {
		entityManager.persist(uf);
		return true;
	}

	public boolean delete(Integer id) {
		Uf uf = findById(id);
		entityManager.remove(uf);
		return true;
	}

}
