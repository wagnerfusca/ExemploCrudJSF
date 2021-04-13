package br.com.aula.dao;

import java.util.List;

public interface DAO<T> {
	List<T> findAll();

	T findById(Integer id);

	List<T> findByName(String name);

	boolean save(T t);

	boolean delete(Integer id);

}