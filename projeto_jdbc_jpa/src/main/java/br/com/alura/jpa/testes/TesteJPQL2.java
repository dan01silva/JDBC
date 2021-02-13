package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		Categoria ctg = new Categoria();
		ctg.setId(3L);

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);//Definindo o tipo da query que será transformada em lista
		//Query query = em.createQuery(jpql); jeito antigo !
		query.setParameter("pCategoria", ctg);

		List<Movimentacao> resultList = query.getResultList();
		// para cada movimentacao na resultlist
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Valor da movimentação :" + movimentacao.getValor());
			System.out.println("Tipo da movimentação :" + movimentacao.getTipoMovimentacao());
			System.out.println("Descrição da movimentacão:" + movimentacao.getDescricao());
		}
	}
}