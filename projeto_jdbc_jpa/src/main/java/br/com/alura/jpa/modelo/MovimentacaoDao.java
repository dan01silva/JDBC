package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class MovimentacaoDao {
	private EntityManager em ;
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEm() {
		return em;
	}
	


	public List<MediaComData> getMediaDariaDasMovimentacoes(){
		
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "select sum(m.valor) from Movimentacao m";
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();//Como só retorna um valor definir SINGLE, evita a criação de uma lista
		
		return somaDasMovimentacoes;
	}
}
