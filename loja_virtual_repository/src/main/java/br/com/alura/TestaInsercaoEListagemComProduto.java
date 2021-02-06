package br.com.alura;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DAO.ProdutoDAO;
import factory.ConnectionFactory;
import modelo.Produto;

public class TestaInsercaoEListagemComProduto {
	//FAMOSA CLASSE DAO
	public static void main(String[] args) throws Exception {

		Produto comoda = new Produto("Comoda", "Comoda Vertical");
		
		try (Connection conn = new ConnectionFactory().recuperarConexao()){//chamando o m�todo que cria a conex�o com o banco
			ProdutoDAO produtoDAO = new ProdutoDAO(conn); //Chamando a classe que grava as informa��es no banco
			produtoDAO.salvar(comoda);//Executando a graca��o
			
			List<Produto> listaProdutos = new ArrayList<Produto>();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
		}
		
		
		System.out.println(comoda.toString());
	}
}
