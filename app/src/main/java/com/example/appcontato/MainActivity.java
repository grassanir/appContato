package com.example.appcontato;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Modelo.Planta;
import com.example.Modelo.ListaContatos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Planta> alPlantas;
    ListView lvContatos;
    ArrayAdapter<Planta> aaContato;
    boolean ordenacao = false;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ListaPlantas");

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListaContatos.getInstance(getApplicationContext()).ordenaNomeAZ();
        alPlantas = ListaContatos.getInstance(getApplicationContext()).getAlContato();

        ListView lvContatos = (ListView) findViewById(R.id.lvContatos);

        aaContato = new ArrayAdapter<Planta>(this, android.R.layout.simple_list_item_1, alPlantas);
        lvContatos.setAdapter(aaContato);

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int posicao, long id) {
                Planta planta = alPlantas.get(posicao);
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                String strContato = planta.getNome();
                Toast.makeText(getApplicationContext(), strContato, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // item será um dos elementos do menu criados no layout menu_main.xml
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                startActivity(new Intent (MainActivity.this, MainActivity2.class));
                return true;
            case R.id.action_add:  // alterna entre A-Z ou Z-A, conforme o valor da boolean ordenacao
                if (!ordenacao) {
                    ordenaAscendente();
                    Toast.makeText(getApplicationContext(), "Ordem alfabética ascendente", Toast.LENGTH_SHORT).show();
                    ordenacao = true;
                } else {
                    ordenaDescendente();
                    Toast.makeText(getApplicationContext(), "Ordem alfabética descendente", Toast.LENGTH_SHORT).show();
                    ordenacao = false;
                }
                aaContato.notifyDataSetChanged(); // avisa que arraylist mudou, o aadapter vai fazer um refresh do list view
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    public void ordenaAscendente(){
        Collections.sort(alPlantas);  // ordenacao natural chamando o compareTo devido ao Comparable
    }

    public void ordenaDescendente(){
        // fazendo uso de outro comparator, criado com classe anônima, para ordem descendente
        Collections.sort(alPlantas, new Comparator<Planta>() {
            @Override
            public int compare(Planta c1, Planta c2) { // interface comparator exige método compare
                return c2.getNome().compareToIgnoreCase(c1.getNome());
            }
        });
    }

}