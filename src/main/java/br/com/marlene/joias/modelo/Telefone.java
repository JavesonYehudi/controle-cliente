package br.com.marlene.joias.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4392173032008838551L;
	private BigInteger id;
	private String tipo;
	private String numero;

	@Id
	@SequenceGenerator(name = "telefone_id_seq", sequenceName = "telefone_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone_id_seq")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return tipo + ", " + numero;
	}
}
