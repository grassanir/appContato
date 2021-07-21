package com.example.Modelo;

import android.content.Context;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ListaContatos{

    private ArrayList<Contato> alContato;
    private static ListaContatos sListaContatos;
    private Context appContext;

    private ListaContatos(Context appContext) {
        this.appContext = appContext;
        alContato = new ArrayList<Contato>();

        //populando hardcoded para teste da lista

        Contato c1 = new Contato ("Fulano de Tal", "fulano@tal.com", 30, 10, 1990);
        Contato c2 = new Contato ("Ciclano de Tal", "ciclano@tal.com", 26, 2, 1980);
        Contato c3 = new Contato ("Beltrano de Tal", "beltrano@tal.com", LocalDate.of(2000, 1, 25));
    }

         // adicionando usuarios ao arraylist
          //alContato.add(c1);
          //alContato.add(c2);
         //4 alContato.add(c3);


    public static ListaContatos getInstance(Context context){
        if (sListaContatos == null){
            sListaContatos = new ListaContatos(context.getApplicationContext());
            }
            return sListaContatos;
    }

    // opcao 1 - usar os metodos getters/setter para interfacear com a classe, escondendo o ArrayList (+segura)
    //quem chama não sabe a estrutura interna da classe

    //opcao 2
    //tornar disponível o ArrayList e assim os demais usam método direto do AL
    public ArrayList<Contato> getAlContato(){
        return alContato;
    }

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
        Collections.sort(lista, new Comparator<Contato>() {
            @Override
            public int compare(Contato c1, Contato c2) {
                return c2.getDataNascimento().compareTo(c1.getDataNascimento());
            }
        });
    }

    public void ordenaDataNascimentoDes() {
        Collections.sort(lista, new Comparator<Contato>() {
            @Override
            public int compare(Contato c1, Contato c2) {
                return c1.getDataNascimento().compareTo(c2.getDataNascimento());
            }
        });
    }

    @Override
    public Iterator<Contato> iterator(){
        return lista.iterator();
    }


}