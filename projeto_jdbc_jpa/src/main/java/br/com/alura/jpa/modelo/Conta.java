package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private Integer agencia;
	private Integer numero;
	private Double saldo;
	private String cliente;
	@OneToMany(mappedBy = "conta") //direcionamento BIdirecional
	private List<Movimentacao> movimentacoes ;
	

	
	public Conta() {
	}

	public Conta(Integer agencia, Integer numero, Double saldo, String nomeCliente) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = nomeCliente;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setCliente(String nomeCliente) {
		this.cliente = nomeCliente;
	}

	public List<Movimentacao> getMovimentacoes() {
		// TODO Auto-generated method stub
		return movimentacoes;
	}
	
	

}