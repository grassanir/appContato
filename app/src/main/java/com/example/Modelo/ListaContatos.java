package com.example.Modelo;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaContatos{
    private ArrayList<Planta> alPlantas;
    private static ListaContatos sListaContatos;
    private Context appContext;


    @RequiresApi(api = Build.VERSION_CODES.O)
    private ListaContatos(Context appContext) {
        this.appContext = appContext;
        alPlantas = new ArrayList<Planta>();

        // populando hardcoded para teste da lista
        // criando três usuários de teste
        Planta c1 = new Planta("Cebolinha", "Tempero", 30, 10, 1990, "24h");
        Planta c2 = new Planta("Salsinha", "Tempero", 8, 7, 1980, "18h");
        Planta c3 = new Planta("Hortelã", "Chá", LocalDate.of(2000, 1, 25), "24");
        Planta c4 = new Planta("Capim Limão", "Chá", LocalDate.of(2020, 1, 25), "24h");
        Planta c5 = new Planta("Cebolin", "Tempero", 30, 10, 1990, "24h");
        Planta c6 = new Planta("Salsin", "Tempero", 8, 7, 1980, "24h");
        Planta c7 = new Planta("Horte", "Chá", LocalDate.of(2000, 1, 25), "24h");
        Planta c8 = new Planta("Capim Lim", "Chá", LocalDate.of(2020, 1, 25), "24h");
        Planta c9 = new Planta("Ceboli", "Tempero", 30, 10, 1990, "24h");
        Planta c10 = new Planta("Salsi", "Tempero", 8, 7, 1980, "24h");
        Planta c11= new Planta("Hort", "Chá", LocalDate.of(2000, 1, 25), "24h");
        Planta c12 = new Planta("Capim Li", "Chá", LocalDate.of(2020, 1, 25), "24h");
        Planta c13 = new Planta("Erva Cidreira", "Chá");
        // adicionando os usuários no array list
        alPlantas.add(c1);
        alPlantas.add(c2);
        alPlantas.add(c3);
        alPlantas.add(c4);
        alPlantas.add(c5);
        alPlantas.add(c6);
        alPlantas.add(c7);
        alPlantas.add(c8);
        alPlantas.add(c9);
        alPlantas.add(c10);
        alPlantas.add(c11);
        alPlantas.add(c12);
        alPlantas.add(c13);
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
    public ArrayList<Planta> getAlContato(){
        return alPlantas;
    }

       // opcao 2
    // usar os metodos getters/setters para interfacear com a classe, escondendo o ArrayList (+segura)
    // assim quem chama não sabe a estrutura de dados usada internamente na classe, apenas conhece sua interface pública

    public void addContato(Planta planta) {
        alPlantas.add(planta);
    }

    public Planta getContato(int posicao) {
        return alPlantas.get(posicao);
    }

    public int size() {
        return alPlantas.size();
    }

    public void ordenaNomeAZ() {
        Collections.sort(alPlantas);
    }

    public void ordenaNomeZA() {
        Collections.sort(alPlantas, Collections.reverseOrder());
    }


    public void ordenaDataNascimentoAsc() {
        Collections.sort(alPlantas, new Comparator<Planta>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public int compare(Planta c1, Planta c2) {
                return c2.getDataPlantio().compareTo(c1.getDataPlantio());
            }
        });
    }

    public void ordenaDataNascimentoDes() {
        Collections.sort(alPlantas, new Comparator<Planta>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public int compare(Planta c1, Planta c2) {
                return c2.getDataPlantio().compareTo(c1.getDataPlantio());
            }
        });
    }

}