package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;//interface que faz a comunicação entre a aplicação e o drive das conexões
	
	
	public ConnectionFactory() { //para criar uma conexão toda vez que classe for chamada 
	ComboPooledDataSource comboPoolDS = new ComboPooledDataSource(); 
		comboPoolDS.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimezone=UTC");
		comboPoolDS.setUser("admin");
		comboPoolDS.setPassword("admin@");
		
		comboPoolDS.setMaxPoolSize(15);
		
		this.dataSource = comboPoolDS;
	}
	
	public Connection recuperarConexao() throws SQLException{
		
		return this.dataSource.getConnection();//pedindo uma conexão do pool de conexões 
		
		/**
		 * Crianco conexao, na URI deve conter, endereço do banco, ip da onde vai rodar,e NOME DO BANCO! configurações de time zona opcional
		 */
		//return  DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimezone=UTC","admin", "admin@");
		
		
	}
}
