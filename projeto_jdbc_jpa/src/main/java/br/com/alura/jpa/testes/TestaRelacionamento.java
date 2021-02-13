package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {
		
		Movimentacao mov = new Movimentacao();
		
		mov.setData(LocalDateTime.now());
		mov.setDescricao("Churrascaria");
		mov.setValor(new BigDecimal(200.0));
		mov.setTipoMOvimentacao(TipoMovimentacao.ENTRADA);
		
		Conta conta = new Conta(5167,718294,400.0, "Marly Regina");
		mov.setConta(conta);
		
		EntityManagerFactory emt = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emt.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);//precisamos persistir a conta, já que ela está sendo referenciada
		em.persist(mov);
		em.getTransaction().commit();
		em.close();
		
		//Mapeando Relacionamento de Entidades
		
	}

}
