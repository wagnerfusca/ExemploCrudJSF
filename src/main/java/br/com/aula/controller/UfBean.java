package br.com.aula.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.aula.model.Uf;

@ManagedBean
@ApplicationScoped
public class UfBean {

	private List<Uf> list;

	private Uf uf;

	@PostConstruct
	public void init() {
		if (list == null) {
			list = new ArrayList<Uf>();
		}
		this.uf = new Uf();

	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public List<Uf> getList() {
		return list;
	}

	public String novo() {
		this.uf = new Uf();
		return "cadastrarUf";
	}

	public String salvar() {
		if (this.uf.getId() != null) {
			list.remove(this.uf);
			list.add(this.uf);
		} else {
			Random random = new Random();
			this.uf.setId(random.nextInt());
			list.add(this.uf);
		}
		return "uf";

	}

	public String editar(Uf uf) {
		this.uf = uf;
		return "cadastrarUf";
	}

	public String remover(Uf uf) {
		list.remove(uf);
		return "uf";
	}

}
