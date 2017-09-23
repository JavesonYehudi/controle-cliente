package br.com.marlene.joias.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.marlene.joias.modelo.venda.Compra;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4392173032008838551L;
	private BigInteger id;
	private String nome;
	private Date nascimento;
	private String nomeMae;
	private String estadoCivil;
	private String sexo;
	private List<Endereco> enderecos;
	private List<Documento> documentos;
	private List<Telefone> telefones;
	private List<Compra> compras;

	public Cliente() {
		enderecos = new ArrayList<>();
		documentos = new ArrayList<>();
		telefones = new ArrayList<>();
		compras = new ArrayList<>();
	}

	public Cliente(BigInteger id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Id
	@SequenceGenerator(name = "cliente_id_seq", sequenceName = "cliente_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_seq")
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Column(name = "nome_mae")
	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	@Column(name = "estado_civil")
	@JoinColumn(name = "cliente_id")
	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer("[");
		return stringBuffer.append(" id: ").append(id).append(", nome: ").append(nome).append(", nascimento: ")
				.append(nascimento).append(", estadoCivil: ").append(estadoCivil).append(", enderecos: ")
				.append(enderecos).append(" ]").toString();
	}
}