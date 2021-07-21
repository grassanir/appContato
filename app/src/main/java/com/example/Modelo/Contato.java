package com.example.Modelo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Contato implements Comparable<Contato> {
    // atributos : definir o estado de um objeto (variáveis), o que o objeto sabe
    private String nome;  // private para garantir o encapsulamento
    private String email;
    private LocalDate dataNascimento; // classe da API do Java para manipulação de datas

    // métodos : definir o comportamento de um objeto (funções), o que o objeto faz

    // método construtor : usado para criar uma instância, um objeto de Contato
    public Contato(String nome) {
        super();  // chama o construtor da super classe
        this.nome = nome;

    }

    public Contato(String nome, String email) {
        super();  // chama o construtor da super classe
        this.nome = nome;
        this.email = email;
    }

    // mais de um método como o mesmo NOME mas ASSINATURA diferente => overload ou sobrecarga
    // para aumentar a flexibilidade na criação de instâncias desta classe
    public Contato(String nome, String email, LocalDate dataNascimento) {
        super();
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    // outra opção de construtor
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Contato(String nome, String email, int dia, int mes, int ano) {
        super();
        this.nome = nome;
        this.email = email;
        this.dataNascimento = LocalDate.of(ano, mes, dia);
    }

    // os getters e setters funcionam de interface pública para
    // acesso aos atributos privados da classe

    // getters são usados para retornar o valor dos atributos
    public String getNome() {
        return nome;
    }

    // setters são usados para alterar o valor dos atributos
    public void setNome(String nome) {
        // lógica de negócio que testa o parâmetro antes de atribuir
        // se não for ok, pode por exemplo lançar um exceção44
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDataNascimentoStrBR() {
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (this.dataNascimento == null)
            return "sem data";
        return this.dataNascimento.format(formatoBR);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getIdade() {
        int idade;
        if (this.dataNascimento == null)
            return 0;
        LocalDate hoje = LocalDate.now();// pega a data de agora, do sistema
        Period tempo = Period.between(this.dataNascimento, hoje);
        idade = tempo.getYears();
        return idade;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setDataNascimento(int dia, int mes, int ano) {
        this.dataNascimento = LocalDate.of(ano, mes, dia);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override // redefinição ou sobrescrita
    // método redefinido para retornar um representação textual do objeto
    public String toString() {
        return nome + "\n" + this.getDataNascimentoStrBR() +" ( "+ this.getIdade() + "anos)";
    }

    @Override
    public int compareTo(Contato contato) {  // A..Z baseado no nome
        return  this.nome.compareTo(contato.getNome());
    }

}
