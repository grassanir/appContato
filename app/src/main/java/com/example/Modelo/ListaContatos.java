package com.example.Modelo;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaContatos{
    private ArrayList<Contato> alContato;
    private static ListaContatos sListaContatos;
    private Context appContext;


    @RequiresApi(api = Build.VERSION_CODES.O)
    private ListaContatos(Context appContext) {
        this.appContext = appContext;
        alContato = new ArrayList<Contato>();

        // populando hardcoded para teste da lista
        // criando três usuários de teste
        Contato c1 = new Contato ("Fulano de Tal", "fulano@tal.com", 30, 10, 1990);
        Contato c2 = new Contato ("Ciclano de Tal", "ciclano@tal.com", 8, 7, 1980);
        Contato c3 = new Contato ("Beltrano de Tal", "beltrano@tal.com", LocalDate.of(2000, 1, 25));
        Contato c4 = new Contato ("José da Silva", "zezinho@tal.com", LocalDate.of(2020, 1, 25));
        // adicionando os usuários no array list
        alContato.add(c1);
        alContato.add(c2);
        alContato.add(c3);
        alContato.add(c4);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ListaContatos getInstance(Context context){
        if (sListaContatos == null){
            sListaContatos = new ListaContatos(context.getApplicationContext());
        }
        return sListaContatos;
    }

    // opcao 1
    // tornar disponível o ArrayList e assim as demais classes usam os métodos de ArrayList direto, sem passar por aqui
    public ArrayList<Contato> getAlContato(){
        return alContato;
    }

    // opcao 2
    // usar os metodos getters/setters para interfacear com a classe, escondendo o ArrayList (+segura)
    // assim quem chama não sabe a estrutura de dados usada internamente na classe, apenas conhece sua interface pública

    public void addContato(Contato contato) {
        alContato.add(contato);
    }

    public Contato getContato(int posicao) {
        return alContato.get(posicao);
    }

    public int size() {
        return alContato.size();
    }

    public void ordenaNomeAZ() {
        Collections.sort(alContato);
    }

    public void ordenaNomeZA() {
        Collections.sort(alContato, Collections.reverseOrder());
    }


    public void ordenaDataNascimentoAsc() {
        Collections.sort(alContato, new Comparator<Contato>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public int compare(Contato c1, Contato c2) {
                return c2.getDataNascimento().compareTo(c1.getDataNascimento());
            }
        });
    }

    public void ordenaDataNascimentoDes() {
        Collections.sort(alContato, new Comparator<Contato>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public int compare(Contato c1, Contato c2) {
                return c2.getDataNascimento().compareTo(c1.getDataNascimento());
            }
        });
    }

}