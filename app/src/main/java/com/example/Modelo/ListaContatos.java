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
        Contato c1 = new Contato ("Cebolinha", "Tempero", 30, 10, 1990);
        Contato c2 = new Contato ("Salsinha", "Tempero", 8, 7, 1980);
        Contato c3 = new Contato ("Hortelã", "Chá", LocalDate.of(2000, 1, 25));
        Contato c4 = new Contato ("Capim Limão", "Chá", LocalDate.of(2020, 1, 25));
        Contato c5 = new Contato ("Cebolin", "Tempero", 30, 10, 1990);
        Contato c6 = new Contato ("Salsin", "Tempero", 8, 7, 1980);
        Contato c7 = new Contato ("Horte", "Chá", LocalDate.of(2000, 1, 25));
        Contato c8 = new Contato ("Capim Lim", "Chá", LocalDate.of(2020, 1, 25));
        Contato c9 = new Contato ("Ceboli", "Tempero", 30, 10, 1990);
        Contato c10 = new Contato ("Salsi", "Tempero", 8, 7, 1980);
        Contato c11= new Contato ("Hort", "Chá", LocalDate.of(2000, 1, 25));
        Contato c12 = new Contato ("Capim Li", "Chá", LocalDate.of(2020, 1, 25));
        // adicionando os usuários no array list
        alContato.add(c1);
        alContato.add(c2);
        alContato.add(c3);
        alContato.add(c4);
        alContato.add(c5);
        alContato.add(c6);
        alContato.add(c7);
        alContato.add(c8);
        alContato.add(c9);
        alContato.add(c10);
        alContato.add(c11);
        alContato.add(c12);
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