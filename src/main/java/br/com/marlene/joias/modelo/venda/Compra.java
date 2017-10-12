package br.com.marlene.joias.modelo.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.marlene.joias.modelo.Cliente;
import br.com.marlene.joias.modelo.Funcionario;

@Entity
@Table(name = "compras")
public class Compra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4392173032008838551L;
	private BigInteger id;
	private List<Item> itens;
	private List<Parcela> parcelas;
	private BigDecimal valorDaParcela;
	private Integer quantidadeDeParcelas;
	private BigDecimal valorDaEntrada;
	private Date dataPrimeiraParcela;
	private Cliente cliente;
	private Date dataDeCriacao;
	private Funcionario funcionario;

	public Compra() {
		itens = new ArrayList<>();
		parcelas = new ArrayList<>();
		dataDeCriacao = new Date();
	}

	@Id
	@SequenceGenerator(name = "compra_id_seq", sequenceName = "compra_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compra_id_seq")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "compra_id")
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "compra_id")
	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	@Transient
	public BigDecimal getValorDaParcela() {
		return valorDaParcela;
	}

	public void setValorDaParcela(BigDecimal valorDaParcela) {
		this.valorDaParcela = valorDaParcela;
	}

	@Transient
	public Integer getQuantidadeDeParcelas() {
		return quantidadeDeParcelas;
	}

	public void setQuantidadeDeParcelas(Integer quantidadeDeParcelas) {
		this.quantidadeDeParcelas = quantidadeDeParcelas;
	}

	@Column(name = "valor_entrada")
	public BigDecimal getValorDaEntrada() {
		return valorDaEntrada;
	}

	public void setValorDaEntrada(BigDecimal valorDaEntrada) {
		this.valorDaEntrada = valorDaEntrada;
	}

	@Column(name = "data_primeira_parcela")
	public Date getDataPrimeiraParcela() {
		return dataPrimeiraParcela;
	}

	public void setDataPrimeiraParcela(Date dataPrimeiraParcela) {
		this.dataPrimeiraParcela = dataPrimeiraParcela;
	}

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Column(name = "data_criacao", updatable = false, nullable = false)
	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Transient
	public boolean isAvista() {
		return this.getParcelas().size() == 1;
	}

	@Transient
	public boolean isQuitado() {
		return this.getParcelas().stream().filter(parcela -> parcela.isPago()).collect(Collectors.toList()).isEmpty();
	}

	@Transient
	public boolean hasEntrada() {
		return this.getValorDaEntrada().doubleValue() > 0;
	}

	@Override
	public String toString() {
		return "Itens: " + itens + ", Quitado: " + (isQuitado() ? "Sim" : "Não");
	}
}
