package br.com.marlene.joias.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5047341143512633360L;

	private BigInteger id;
	private Estado estado;
	private Cidade cidade;
	private String cep;
	private String bairro;
	private String logradouro;
	private String complemento;
	private String tipo;

	@Id
	@SequenceGenerator(name = "endereco_id_seq", sequenceName = "endereco_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_id_seq")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "estado_id")
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer("[");
		return stringBuffer
				.append(" id: ").append(id)
				.append(", estado: ").append(estado)
				.append(", cidade: ").append(cidade)
				.append(", cep: ").append(cep)
				.append(", bairro: ").append(bairro)
				.append(", logradouro: ").append(logradouro)
				.append(", complemento: ").append(complemento)
				.append(", tipo: ").append(tipo)
				.append(" ]")
				.toString();
	}
}
