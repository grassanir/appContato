package com.example.appcontato;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Modelo.Contato;
import com.example.Modelo.ListaContatos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contato> alContato;
    ListView lvContatos;
    ArrayAdapter<Contato> aaContato;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaContatos.getInstance(getApplicationContext()).ordenaNomeAZ();
        alContato = ListaContatos.getInstance(getApplicationContext()).getAlContato();

        ListView lvContatos = (ListView) findViewById(R.id.lvContatos);

        aaContato = new ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, alContato);
        lvContatos.setAdapter(aaContato);

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int posicao, long id) {
                Contato contato = alContato.get(posicao);
                String strContato = contato.getNome();
                Toast.makeText(getApplicationContext(), strContato, Toast.LENGTH_LONG).show();
            }
        });
    }
}