package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.MovimentacaoDao;

public class TestaSomaMovimentacaoComCriteria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);//devemos passar como arg (a/o CLASSE/TIPO) DE RETORNO DA QUERY
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		//Espressão OO == sum(m.valor)
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);//passando para o select
		
		 TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		 typedQuery.getSingleResult();//RESULT SINNGLE não precisa instanciar ASSING STATEMANT
		
		System.out.println("Soma das Movimentações: " + typedQuery.getSingleResult());		
	}
}