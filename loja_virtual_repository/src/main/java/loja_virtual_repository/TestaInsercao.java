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
		 *M� Pratica usar INJECT SQL, sua aplica��o vuner�vel, algu�m com conheciemtos t�cnicos
		 *pode causar graves preju�zos as informa��es no seu banco, j� que ele consegue escrever um comando que vai ser executado direto no seu banco
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
