package br.com.alura.jpa.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDao {
    private Connection conn;

    public ContaDao() {
        try {
            this.conn = DriverManager.getConnection("mysql://localhost/alura_jdbc", "admin", "admin@");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adiciona(Conta conta) {
        try {
            String sql = "insert into conta(agencia, numero, titular) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, conta.getAgencia());
            ps.setLong(2, conta.getNumero());
            ps.setString(3, conta.getTitular());

            ps.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}