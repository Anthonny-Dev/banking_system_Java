package br.com.banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class MenuApplication {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------\nINTERNATIONAL BANKING SYSTEM\n----------------------------------\n1 - CREATE A ACCOUNT\n2 - LOGIN\n3 - ACESS AN EXISTING ACCOUNT\n4 - EXIT SYSTEM\n Choice a Option:");

        int choice = scanner.nextInt();

        switch (choice){
            // Esse é o menu principal da aplicação
            case 1:
                // vamos inicializar o método Scanner e armazenar seus inputs em variáveis exatamente iguais as do BD MySQL pra que não ocorra erros de interferencia.
                Scanner sc = new Scanner(System.in);

                System.out.println("Client CPF: ");
                String cpf = sc.nextLine();

                System.out.println("Client Name: ");
                String name = sc.nextLine();

                System.out.println("Client Account: ");
                int account = sc.nextInt();

                System.out.println("Client Password: ");
                int senhaConta = sc.nextInt();
                sc.nextLine();

                System.out.println("Client Birthday (formato: dd/MM/yyyy): ");
                String dateInput = sc.nextLine();

                // Utlizamos o método DateTimeFormatter para formatar input da data de nascimento do usuário para Local Date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dateBirthday = LocalDate.parse(dateInput, formatter);

                System.out.println("Client Email: ");
                String email = sc.nextLine();

                // we create a variable type 'Account' for storage the value of the inputs in a new account
                // criamos uma váriavel do tipo 'Account' para armazenar o valor dos inputs em uma nova conta
                Account novaconta = new Account(0, cpf, name, account, senhaConta, dateBirthday, email);

                // we create a temporary variable for create a new instance from createAccount class
                // criamos uma variável temporária para criar uma nova instancia da classe createAccount
                createAccount dao = new createAccount();

                // we create the account, following the logic's method: createaccount from createAccount class
                // criamos de fato a conta, seguindo a lógica do METODO: createaccount da CLASSE: createAccount
                dao.createaccount(novaconta);

            break;
            case 2:
                Login login = new Login();
                login.Logar();
                break;
            case 3:
                System.out.println("acessando...");
                AcessAccount enteraccount = new AcessAccount();
                enteraccount.Acess();
                break;
            case 4:
                System.out.println("Exit Programming...");
                break;
            default:
                System.out.println("Tente Novamente.\n");

        }
    }
}
