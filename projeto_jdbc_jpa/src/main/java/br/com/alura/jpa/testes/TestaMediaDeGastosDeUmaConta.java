package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaMediaDeGastosDeUmaConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor) mediaValor from Movimentacao m join Conta c on 1=1";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		
		 Double singleResultMedi = query.getSingleResult();
		 
		 System.out.println("Resultado :" + singleResultMedi);
		 
		 //INPLEMENTAÇÃO FAILLL
		 
		 //TENTAR NOVAMENTE - 14/02
	}

}
