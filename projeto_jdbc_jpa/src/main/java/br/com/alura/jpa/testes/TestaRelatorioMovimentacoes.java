package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		
		String jpql = "Select c from Conta c join fetch c.movimentacoes";
		TypedQuery<Conta> query= em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		for (Conta conta : contas) {
			System.out.println("Titular: "+ conta.getCliente());
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Conta: " +conta.getNumero());
			// carrega os relacionamntos TOMANY em lazy (de forma mais lenta, alterar o estado no relacionamento) 
			System.out.println("Movimentações: " + conta.getMovimentacoes());
		}
	}

}
