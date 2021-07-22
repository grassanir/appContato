package com.example.appcontato;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Modelo.Planta;
import com.example.Modelo.ListaContatos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Planta> alPlantas;
    ListView lvContatos;
    ArrayAdapter<Planta> aaContato;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de Plantas");

        ListaContatos.getInstance(getApplicationContext()).ordenaNomeAZ();
        alPlantas = ListaContatos.getInstance(getApplicationContext()).getAlContato();

        ListView lvContatos = (ListView) findViewById(R.id.lvContatos);

        aaContato = new ArrayAdapter<Planta>(this, android.R.layout.simple_list_item_1, alPlantas);
        lvContatos.setAdapter(aaContato);

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int posicao, long id) {
                Planta planta = alPlantas.get(posicao);
                String strContato = planta.getNome();
                Toast.makeText(getApplicationContext(), strContato, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);
        return super.onCreateOptionsMenu(menu);

    }
}