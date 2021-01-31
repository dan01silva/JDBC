package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.recuperarConexao();
		
		Statement stm = conn.createStatement();
		
		stm.execute("insert into produto(nome, descricao) values('MOUSE' , 'MOUSE SEM FIO')", Statement.RETURN_GENERATED_KEYS );
		
		ResultSet rts= stm.getGeneratedKeys();
		
		while (rts.next()) {
			Integer id = rts.getInt(1);	
			System.out.println(" O id criado foi: " + id);
			
		}
	}
}
