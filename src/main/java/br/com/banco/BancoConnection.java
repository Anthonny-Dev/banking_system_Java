package br.com.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bancodatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "@Computador1908";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("Conectando ao banco de dados...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso.");

                statement = connection.createStatement();

                /* INJETANDO DADOS NA TABELA CLIENTE VIA IDE
                OBS: É NECESSÁRIO ANALISAR A TABELA E VERIFICAR QUAIS ATRIBUTOS SÃO NOT NULL
                PARA NÃO OCORRER ERROS NA INJEÇÃO DE INFORMAÇÕES.
                */

                /* OBS: APÓS A INSERÇÃO DOS DADOS NA TABELA, NÃO É POSSÍVEL RODAR O CÓDIGO NOVAMENTE,
                TENDO EM VISTA QUE IRÁ DUPLICAR OS DADOS
                String Insertsql = "INSERT INTO cliente(cpf, nome, contaCliente, senhaConta, dataNascimento, email)" +
                        "VALUES('09612367847', 'Ciclano', 2345, 0987, '1999-01-01', 'ciclano@gmail.com')";
                int valuesUpdated = statement.executeUpdate(Insertsql);

                System.out.println("Updates na tabela CLIENTE" + valuesUpdated);
                 */

                String sql = "SHOW TABLES";
                resultSet = statement.executeQuery(sql);


                System.out.println("\n Tabelas no banco de dados 'banco_database':");
                int count = 1;
                while (resultSet.next()) {
                    String tableName = resultSet.getString(1);
                    System.out.println(count + ". " + tableName);
                    count++;
                }

                System.out.println("\n Clientes cadastrados:");
                sql = "SELECT * FROM cliente";
                resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int id_cliente = resultSet.getInt("id_cliente");
                    String cpf = resultSet.getString("cpf");
                    String nome = resultSet.getString("nome");
                    long contaCliente = resultSet.getLong("contaCliente");
                    int senha = resultSet.getInt("senhaConta");
                    String dataNascimento = resultSet.getString("dataNascimento");
                    String email = resultSet.getString("email");

                    System.out.printf("ID: %d |\n CPF: %s |\n Nome: %s |\n Conta: R$%d |\n Email: %s\n________________________________________________\n",
                            id_cliente, cpf, nome, contaCliente, email);
                }

                /*System.out.println("\n Clientes cadastrados:");
                sql = "SELECT id_cliente, cpf, nome, contaCliente, email FROM cliente";
                resultSet = statement.executeQuery(sql); //OBS: O executeQuery só funciona para SELECT'S

                while (resultSet.next()) {
                    int id_cliente = resultSet.getInt("id_cliente");
                    String cpf = resultSet.getString("cpf");
                    String nome = resultSet.getString("nome");
                    long contaCliente = resultSet.getInt("contaCliente");
                    String email = resultSet.getString("email");

                    System.out.printf("ID: %d |\n CPF: %s |\n Nome: %s |\n Conta: R$%d |\n Email: %s\n________________________________________________\n",
                            id_cliente, cpf, nome, contaCliente, email);
                }*/

            }

            /* TESTE: TENTANDO ADICIONAR UM CLIENTE NA TABELA VIA IDE
            String sql = "INSERT INTO cliente(cpf, nome, contaCliente, email)" +
                    "VALUES('09612367847', 'Ciclano', 2345, 'ciclano@gmail.com')";
            int valuesUpdated = statement.executeUpdate(sql);

            System.out.println("Updates na tabela CLIENTE" + valuesUpdated);

            sql = "SHOW TABLES";
            resultSet = statement.executeQuery(sql);*/

        } catch (SQLException e) {
            System.err.println(" Erro na conexao com o banco de dados:");
            System.err.println("Mensagem: " + e.getMessage());
            System.err.println("Código de erro: " + e.getErrorCode());
            System.err.println("Estado SQL: " + e.getSQLState());

        } finally {

            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) {
                    connection.close();
                    System.out.println("\n Conexão fechada.");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
