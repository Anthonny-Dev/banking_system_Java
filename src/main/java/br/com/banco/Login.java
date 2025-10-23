package br.com.banco;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// create a class just for login and we create a method for Logar
public class Login {

    public void Logar(){

        Scanner scannerlog = new Scanner(System.in);

        System.out.println("Digite seu CPF:");
        String cpflog = scannerlog.nextLine();

        System.out.println("Digite sua senha da conta:");
        int senhaconta = scannerlog.nextInt();

        String sql = "SELECT * FROM cliente WHERE cpf = ? AND senhaConta = ?";
        // Here we create the sql command, the "?" need be replaced by the variables using the preparedStatement

        try(Connection conn = BancoConnection.getConnection();
            PreparedStatement stmtlog = conn.prepareStatement(sql)){
            // The PreparedStatement knows exactly what command will be executed - he already has been pre-compiled and optimized by JDBC Driver
            //o PreparedStatement sabe exatamente qual comando será executado - ele já foi “pré-compilado” e otimizado pelo driver JDBC.

            stmtlog.setString(1, cpflog);
            stmtlog.setInt(2, senhaconta);

            ResultSet rs = stmtlog.executeQuery();
            // Here we don't use the sql inside the parenteses because the sql already been prepared before
            //O executeQuery() só executa o comando que já está armazenado no objeto stmt, o SQL já foi “preparado” antes


            if (rs.next()){
                System.out.println("\nlogin Concluído com sucesso!");
                System.out.println("Seja Bem Vindo " + rs.getString("nome") + "!");
            }
            else {
                System.out.println("Dados Incorretos!");
            }
        }
        catch (SQLException e){
            System.err.println("Erro ao Conectar com o Banco de dados!" + e.getMessage());
        }

    }
}
