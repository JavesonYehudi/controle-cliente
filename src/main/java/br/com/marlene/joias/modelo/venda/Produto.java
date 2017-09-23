package br.com.marlene.joias.modelo.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5297755610246995321L;

	private BigInteger id;
	private String nome;
	private BigDecimal valor;

	@Id
	@SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_id_seq")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "nome: " + nome + ", valor: " + valor.toString();
	}
}
