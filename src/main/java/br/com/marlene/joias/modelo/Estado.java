package br.com.marlene.joias.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2463282215577972986L;
	private Integer id;
	private String nome;
	private String sigla;
	private List<Cidade> cidades;

	public Estado() {
		cidades = new ArrayList<>();
	}

	public Estado(Integer id) {
		this.id = id;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@OneToMany(mappedBy = "estado")
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public String toString() {
		return sigla + " - " + nome;
	}
}
