package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public abstract class TestandoEstados {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		//Transient
		conta.setTitular("Almir");
		conta.setAgencia(5678);
		conta.setNumero(112345);
		conta.setSaldo(200.0);
		
		EntityManagerFactory emt = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emt.createEntityManager();
		
		
		em.getTransaction().begin();
		// Transient ==> Managed
		em.persist(conta);
		
		// Managed ==> REMOVED 
		em.remove(conta);
		
		em.getTransaction().commit();
	}

}
