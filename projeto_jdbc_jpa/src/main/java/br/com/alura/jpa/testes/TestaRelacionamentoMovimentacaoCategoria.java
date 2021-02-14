package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		
		Conta conta = new Conta ();
		conta.setId(1L);
		
		Categoria ctg = new Categoria("Viajem");
		Categoria ctg2 = new Categoria("Negócios");
		
		Movimentacao mov = new Movimentacao();
		mov.setDescricao("Jogo do SP");	
		mov.setTipoMOvimentacao(TipoMovimentacao.SAIDA);
		mov.setData(LocalDateTime.now());
		mov.setValor(new BigDecimal(78.56));
		mov.setCategoria(Arrays.asList(ctg2));
		mov.setConta(conta);
		
//		Movimentacao mov2 = new Movimentacao();
//		mov2.setDescricao("Viagem à RJ");
//		mov2.setTipoMOvimentacao(TipoMovimentacao.SAIDA);
//		mov2.setData(LocalDateTime.now().plusDays(1));
//		mov2.setValor(new BigDecimal(130.99));
//		mov2.setCategoria(Arrays.asList(ctg,ctg2));
//		mov2.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//em.persist(ctg);	
		em.persist(ctg2);
		em.persist(mov);
		//em.persist(mov2);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
