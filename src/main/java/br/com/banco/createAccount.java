package br.com.banco;

import java.sql.*;
import java.util.Scanner;

/* CRIAMOS UMA CLASSE PARA CRIAR NOVAS CONTAS DENTRO DO BANCO SQL, EVITANDO CRIAR NA CLASSE ACCOUNT.JAVA
 PARA REDUZIR A QUANTIDDAE DE DEPENDENCIAS DA CLASSE E AUMENTAR A MANUTENABILIDDAE DO CÓDIGO*/

public class createAccount {

    /*MÉTODO DA LÓGICA DE CRIAÇÃO DE NOVAS CONTAS*/
    public void createaccount(Account account) throws SQLException {
        String sql = "INSERT INTO cliente(cpf, nome, contaCliente, senhaConta, dataNascimento, email) VALUES (?, ?, ?, ?, ?, ?)";

        // CRIAMOS UMA CONEXÃO COM O BANCO DE DADOS
        try(Connection conn = BancoConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            // Usamos o PreparedStatement para executar comandos SQL de forma segura no Java e passar para o nosso BD MySQL

            // PASSAMOS PARA O MÉTODO STATEMENT OS ATRIBUTOS QUE ELE DEVE TRANSFORMAR DE JAVA -> SQL DE ACORDO COM A ORDEM DO INDEX
            stmt.setString(1, account.getCpf());
            stmt.setString(2, account.getNome());
            stmt.setInt(3, account.getContaCliente());
            stmt.setInt(4, account.getSenhaConta());
            stmt.setDate(5, java.sql.Date.valueOf(account.getDataNascimento()));
            stmt.setString(6, account.getEmail());

            int rowsAtualizados = stmt.executeUpdate();
            if (rowsAtualizados > 0){
                System.out.println("Cadastro concluído com sucesso!");
            }
            else{
                System.out.println("Erro ao cadastrar.");
            }

        }
        catch (SQLException e){
            System.err.println("Erro ao criar conta:" + e.getMessage());
        }

    }
}
