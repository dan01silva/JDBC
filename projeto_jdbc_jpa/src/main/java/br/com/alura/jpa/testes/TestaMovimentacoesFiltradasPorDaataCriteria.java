package br.com.alura.jpa.testes;

import java.util.Formatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.MovimentacaoDao;

public class TestaMovimentacoesFiltradasPorDaataCriteria {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(em);

		List<Movimentacao> movimentacoesFiltradasPorData = dao.getMovimentacoesFiltradasPorData(null, null, 2020);
		for (Movimentacao movimentacao : movimentacoesFiltradasPorData) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Data: " + movimentacao.getData());
			System.out.println("Valor : " + movimentacao.getValor());
			System.out.println("---------------------------------------------");
		}
	}
}