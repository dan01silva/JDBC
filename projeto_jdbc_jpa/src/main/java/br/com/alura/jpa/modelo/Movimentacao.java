package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private BigDecimal valor;
	private TipoMovimentacao tipoMovimentacao;
	private LocalDateTime data;
	private String descricao;
	@ManyToMany//Muitos para Muitos
	private List<Categoria> categorias = new ArrayList<Categoria>();
	@ManyToOne // Muitos para 1
	private Conta conta; //Mapeando Relacionamento de Entidades
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMOvimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Categoria> getCategoria() {
		return categorias; 
	}

	public void setCategoria(List<Categoria> categorias) {
		this.categorias = categorias; 
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + " Valor:" + this.valor + " Tipo de movimentação" + this.tipoMovimentacao + " Data e hora " + this.data ;
	}
}
