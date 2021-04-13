package br.com.aula.model;

import javax.persistence.Query;

import org.junit.Test;

public class UfTest extends AbstractTest {
	@Test
	public void inserirTest() {

		inserirUf();

		atualizaUf();

	}

	private void atualizaUf() {
		Query q = manager.createQuery("from Uf where sigla = :pSigla");
		q.setParameter("pSigla", "AM");
		q.setMaxResults(1);
		Uf uf = (Uf) q.getSingleResult();

		System.out.println(uf.getId() + " - " + uf.getSigla() + " - " + uf.getNome());

		uf.setNome("AAAAA");
		manager.getTransaction().begin();
		manager.persist(uf);
		manager.getTransaction().commit();

		System.out.println(uf.getId() + " - " + uf.getSigla() + " - " + uf.getNome());
	}

	private void inserirUf() {
		Uf uf = new Uf();
		uf.setNome("Amazonas");
		uf.setSigla("AM");

		manager.getTransaction().begin();
		manager.persist(uf);
		manager.getTransaction().commit();
	}

}
