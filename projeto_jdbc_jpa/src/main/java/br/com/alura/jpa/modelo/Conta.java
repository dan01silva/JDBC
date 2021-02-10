package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {//representação de uma Entidade
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	
	public Conta() {
	}

	public Conta(Integer agencia, Integer numero, String titular) {
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
	}

	public Integer getId() {
		return id;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

}