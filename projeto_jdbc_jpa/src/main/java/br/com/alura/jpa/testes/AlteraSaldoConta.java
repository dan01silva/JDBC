package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {
	public static void main(String[] args) {

		EntityManagerFactory emt = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emt.createEntityManager();

		Conta accAmanda = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();//open transaction 

		accAmanda.setSaldo(60.0);

		em.getTransaction().commit();//close transaction
	}
}