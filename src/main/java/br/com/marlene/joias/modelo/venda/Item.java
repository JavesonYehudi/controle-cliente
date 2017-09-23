package br.com.marlene.joias.modelo.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "itens")
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6204126686833157665L;
	private BigInteger id;
	private int quantidade;
	private Produto produto;
	private BigDecimal valorUnitario;

	@Id
	@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@ManyToOne
	@JoinColumn(name = "produto_id")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Column(name = "valor_unitario")
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Transient
	public BigDecimal getValorTotal() {
		return valorUnitario.multiply(new BigDecimal(quantidade));
	}

	@Override
	public String toString() {
		return "produto: " + produto.getNome() + ", valor unitário: "
				+ valorUnitario.toString() + ", quantidade: " + quantidade + ", total: " + getValorTotal().toString();
	}
}