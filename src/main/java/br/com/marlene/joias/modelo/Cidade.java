package br.com.marlene.joias.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidades")
public class Cidade {
	private Integer id;
	private String nome;
	private Estado estado;
	private String gentilico;

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

	@ManyToOne
	@JoinColumn(name = "estado_id")
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getGentilico() {
		return gentilico;
	}

	public void setGentilico(String gentilico) {
		this.gentilico = gentilico;
	}

	@Override
	public String toString() {
		return nome;
	}
}
