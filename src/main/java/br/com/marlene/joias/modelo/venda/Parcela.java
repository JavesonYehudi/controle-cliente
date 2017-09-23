package br.com.marlene.joias.modelo.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "parcelas")
public class Parcela implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4125042547421441105L;
	private BigInteger id;
	private Date dataVencimento;
	private BigDecimal valorVencimento;
	private Date dataPagamento;
	private BigDecimal valorPagamento;

	@Id
	@SequenceGenerator(name = "parcela_id_seq", sequenceName = "parcela_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parcela_id_seq")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = "data_vencimento", nullable = false)
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Column(name = "valor_vencimento", nullable = false)
	public BigDecimal getValorVencimento() {
		return valorVencimento;
	}

	public void setValorVencimento(BigDecimal valorVencimento) {
		this.valorVencimento = valorVencimento;
	}

	@Column(name = "data_pagamento")
	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Column(name = "valor_pagamento")
	public BigDecimal getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(BigDecimal valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	@Transient
	public boolean isPago() {
		return this.dataPagamento != null;
	}

	@Override
	public String toString() {
		return "Data de vencimento: " + dataVencimento.toString() + ", Valor do vencimento: "
				+ valorVencimento.toString();
	}
}
