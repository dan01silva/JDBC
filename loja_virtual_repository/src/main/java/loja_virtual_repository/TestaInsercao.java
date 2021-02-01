package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.recuperarConexao();
		
		/**
		 *Má Pratica usar INJECT SQL, sua aplicação vunerável, alguém com conheciemtos técnicos
		 *pode causar graves prejuízos as informações no seu banco, já que ele consegue escrever um comando que vai ser executado direto no seu banco
		 */
		Statement stm = conn.createStatement();
		stm.execute("insert into produto(nome, descricao) values('MOUSE' , 'MOUSE SEM FIO')", Statement.RETURN_GENERATED_KEYS ); //return chave automaticamente
		ResultSet rts= stm.getGeneratedKeys();
		
		while (rts.next()) {
			Integer id = rts.getInt(1);	
			System.out.println(" O id criado foi: " + id);
			
		}
	}
}
