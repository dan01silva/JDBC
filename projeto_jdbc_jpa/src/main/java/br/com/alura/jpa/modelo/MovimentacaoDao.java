package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MovimentacaoDao {
	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer day, Integer month, Integer year) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		List<Predicate> pred = new ArrayList<Predicate>();
		
		if (day != null) {
			//day(m.data)
			 Predicate equal = builder.equal(builder.function("day", Integer.class, root.get("data")), day);
			 pred.add(equal);
		}
		if (month != null) {
			//month(m.data)
			 Predicate equal = builder.equal(builder.function("month", Integer.class, root.get("data")), month);
			 pred.add(equal);
		}	
		if (year != null) {
			//year(m.data)
			 Predicate equal = builder.equal(builder.function("year", Integer.class, root.get("data")), year);
			 pred.add(equal);
		}
		
		 //transformando Lista de predicates para um Array.
		query.where((Predicate[]) pred.toArray(new Predicate[0]));
		//new Predicate == com isso criamos um array para cada elemento
		//afim de não criar um array com espaços desnecessários
		
		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}

	public List<MediaComData> getMediaDariaDasMovimentacoes() {

		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "select sum(m.valor) from Movimentacao m";

		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();// Como só retorna um valor definir SINGLE, evita a
																	// criação de uma lista

		return somaDasMovimentacoes;
	}
}
