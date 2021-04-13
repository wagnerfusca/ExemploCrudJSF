package br.com.aula.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractTest {
	protected EntityManagerFactory factory;
	protected EntityManager manager;
	
	@Before
	public void init(){
		factory = Persistence.createEntityManagerFactory("id_persistencia");
		manager = factory.createEntityManager();
	}
	
	@After
	public void fim(){
		factory.close();
	}
}
