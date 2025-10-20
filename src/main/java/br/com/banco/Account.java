package br.com.banco;

import java.time.LocalDate;


// creating the class Account
public class Account {
    private int id_cliente;
    private String cpf;
    private String nome;
    private int contaCliente;
    private int senhaConta;
    private LocalDate dataNascimento;
    private String email;


    public Account(int id_cliente, String cpf, String nome, int contaCliente, int senhaConta, LocalDate dataNascimento, String email) {
        this.id_cliente = id_cliente;
        this.cpf = cpf;
        this.nome = nome;
        this.contaCliente = contaCliente;
        this.senhaConta = senhaConta;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }


    // CRIAMOS OS GETTER E SETTERS DA CLASSE
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(int contaCliente) {
        this.contaCliente = contaCliente;
    }

    public int getSenhaConta() {
        return senhaConta;
    }

    public void setSenhaConta(int senhaCliente) {
        this.senhaConta = senhaConta;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
