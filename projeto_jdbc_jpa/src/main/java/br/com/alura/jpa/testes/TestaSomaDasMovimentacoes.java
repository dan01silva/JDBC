package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		BigDecimal somaDasMovimentacoes = dao.getSomaDasMovimentacoes(); //chamando o método da classe DAO
		
		System.out.println("Soma das Movimentações: " + somaDasMovimentacoes);
	}
}