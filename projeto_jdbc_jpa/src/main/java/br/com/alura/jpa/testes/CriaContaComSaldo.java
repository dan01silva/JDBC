package br.com.alura.jpa.testes;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		
		
		//gerando Randomicamente dados da conta !
		Random random = new Random();
		Integer nAgencia = (Integer) random.nextInt(9999);
		Integer nConta = (Integer) random.nextInt(999999);

		EntityManagerFactory emt = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emt.createEntityManager();
		
		Conta conta = new Conta();
		conta.setCliente("Guilherme Rodrigues");
		conta.setSaldo(124.45);
		//Random()
		conta.setAgencia(nAgencia);
		conta.setNumero(nConta);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		
//		EntityManager em2 = emt.createEntityManager();
//		System.out.println("Conta da marly" + conta.getId());
//		conta.setSaldo(500.0);
//		em2.getTransaction().begin();
//		em2.merge(conta);
//		em2.getTransaction().commit();
	}
}