package br.com.banco;

import org.omg.CORBA.WStringSeqHelper;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// classe feita somente para testar se o código funciona corretamente
public class testClient extends BancoConnection{
    public static void main(String[] args) {
        //Account account1 = new Account(1, "12345678910", "Fulano", 1908, "fulanin@gmail.com");

        //System.out.println(account1.getContaCliente());

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

    }
}
