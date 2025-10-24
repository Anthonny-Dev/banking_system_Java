package br.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// we create the class for searching account in database
public class AcessAccount {

    // here we create the method and logics using the SQL commands
    public void Acess(){

        Scanner acesso = new Scanner(System.in);

        System.out.println("ACESS A ACCOUNT\n");
        System.out.println("Digite o CPF:");
        // create a input for read the cpfacesso variable
        String cpfacesso = acesso.nextLine();

        // create the sql command for select the cliente with the parameters
        String sql = "SELECT * FROM Cliente WHERE cpf = ?";

        // making the connection with the database
        try(Connection conn = BancoConnection.getConnection();
            PreparedStatement stmtlog = conn.prepareStatement(sql)){

            // seting the input in parameter of the table(cpf)
            stmtlog.setString(1, cpfacesso);

            // rs variable stores the seting from the variable stmtlog and execute the query on the database
            ResultSet rs = stmtlog.executeQuery();

            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                long contaCliente = rs.getLong("contaCliente");
                int senha = rs.getInt("senhaConta");
                String dataNascimento = rs.getString("dataNascimento");
                String email = rs.getString("email");

                System.out.printf("ID: %d |\n CPF: %s |\n Nome: %s |\n Conta: %d |\n Email: %s\n________________________________________________\n",
                        id_cliente, cpf, nome, contaCliente, email);
            }

        }
        catch (SQLException e){
            System.err.println("Erro ao Conectar com o Banco de dados!" + e.getMessage());
        }

    }
}
