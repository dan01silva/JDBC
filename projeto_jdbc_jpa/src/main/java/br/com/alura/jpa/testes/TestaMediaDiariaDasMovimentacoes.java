package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.MovimentacaoDao;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		List<MediaComData> mediaDariaDasMovimentacoes = dao.getMediaDariaDasMovimentacoes(); //chamnado o método
		
		
		for (MediaComData media : mediaDariaDasMovimentacoes) {
			System.out.println(
					"A media das movimentações do dia: "+ media.getDay() + "/" + media.getMonth() + "/n o valor é :" + media.getValor() );
		}
	}
}