package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {

		EntityManagerFactory emt = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emt.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Marly");
		conta.setAgencia(4567);
		conta.setNumero(456789);
		conta.setSaldo(674.0);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		
		EntityManager em2 = emt.createEntityManager();
		
		System.out.println("Conta da marly" + conta.getId());
		conta.setSaldo(500.0);
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}