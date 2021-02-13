package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {

		EntityManagerFactory emt = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emt.createEntityManager();

		Conta conta = new Conta();
		conta.setCliente("Leonardo");
		conta.setAgencia(1234);
		conta.setNumero(123456);

	
		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
	}
}