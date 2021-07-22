package com.example.Modelo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.of;

public class Planta implements Comparable<Planta> {
    // atributos : definir o estado de um objeto (variáveis), o que o objeto sabe
    private String nome;  // private para garantir o encapsulamento
    private String categoria;
    private LocalDate dataPlantio; // classe da API do Java para manipulação de datas
    private LocalDate dataColheita;
    private String tipoPlantio, origemPlantio, periodoRega, quantidadeAgua, ambiente, estacao, fertilizante;


    // métodos : definir o comportamento de um objeto (funções), o que o objeto faz

    // método construtor : usado para criar uma instância, um objeto de Contato
    public Planta(String nome) {
        super();  // chama o construtor da super classe
        this.nome = nome;
    }

    public Planta(String nome, String categoria) {
        super();  // chama o construtor da super classe
        this.nome = nome;
        this.categoria = categoria;
    }

    // mais de um método como o mesmo NOME mas ASSINATURA diferente => overload ou sobrecarga
    // para aumentar a flexibilidade na criação de instâncias desta classe
    public Planta(String nome, String categoria, LocalDate dataPlantio) {
        super();
        this.nome = nome;
        this.categoria = categoria;
        this.dataPlantio = dataPlantio;
    }

    public Planta(String nome, String categoria, LocalDate dataPlantio, String periodoRega) {
        super();
        this.nome = nome;
        this.categoria = categoria;
        this.dataPlantio = dataPlantio;
        this.periodoRega = periodoRega;
    }

    // outra opção de construtor

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Planta(String nome, String categoria, int dia, int mes, int ano) {
        super();
        this.nome = nome;
        this.categoria = categoria;
        this.dataPlantio = of(ano, mes, dia);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Planta(String nome, String categoria, int dia, int mes, int ano,  String periodoRega) {
        super();
        this.nome = nome;
        this.categoria = categoria;
        this.dataPlantio = of(ano, mes, dia);
        this.periodoRega = periodoRega;
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
        // se não for ok, pode por exemplo lançar um exceção
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataPlantio() {
        return dataPlantio;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDataPlantioStrBR() {
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (this.dataPlantio == null)
            return "sem data";
        return this.dataPlantio.format(formatoBR);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getIdade() {
        int idade;
        if (this.dataPlantio == null)
            return 0;
        LocalDate hoje = LocalDate.now();// pega a data de agora, do sistema
        Period tempo = Period.between(this.dataPlantio, hoje);
        idade = tempo.getYears();
        return idade;
    }

    public void setDataPlantio(LocalDate dataPlantio) {
        this.dataPlantio = dataPlantio;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setDataNascimento(int dia, int mes, int ano) {
        this.dataPlantio = of(ano, mes, dia);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override // redefinição ou sobrescrita
    // método redefinido para retornar um representação textual do objeto
    public String toString() {
        return "Nome: " + nome + "\n\n" + "Categoria: " + this.getCategoria() + "\n\n" + "Plantado em " + this.getDataPlantioStrBR() + "\n\n" + "Rega: " + this.periodoRega
                ;
    }

    @Override
    public int compareTo(Planta planta) {  // A..Z baseado no nome
        return  this.nome.compareTo(planta.getNome());
    }

}
