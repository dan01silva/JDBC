

package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(2L);

		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);//Definindo o tipo da query que será transformada em lista
		//Query query = em.createQuery(jpql); jeito antigo !
		query.setParameter("pConta", conta);

		List<Movimentacao> resultList = query.getResultList();
		// para cada movimentacao na resultlist
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Valor da movimentação :" + movimentacao.getValor());
			System.out.println("Tipo da movimentação :" + movimentacao.getTipoMovimentacao());
			System.out.println("Descrição da movimentacão:" + movimentacao.getDescricao());
		}
	}
}