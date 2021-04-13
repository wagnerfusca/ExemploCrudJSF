package br.com.aula.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aula.dao.impl.UfDao;
import br.com.aula.model.Uf;

@Component
@ManagedBean
@ApplicationScoped
public class UfBean {

	@Autowired
	UfDao ufDao;

	private List<Uf> list;

	private Uf uf;

	@PostConstruct
	public void init() {
		if (list == null) {
			list = ufDao.findAll();
		}
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
		if (ufDao.save(this.uf)) {
			list = ufDao.findByName(this.uf.getNome());
		}
		return "uf";

	}

	public String editar(Uf uf) {
		this.uf = uf;
		return "cadastrarUf";
	}

	public String remover(Uf uf) {
		ufDao.delete(uf.getId());
		return "uf";
	}

}
