package com.example.appcontato;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Modelo.Planta;
import com.example.Modelo.ListaContatos;

import java.util.ArrayList;

public class DadosContato extends AppCompatActivity {
    ArrayList<Planta> alPlantas;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_contato);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        alPlantas = ListaContatos.getInstance(getApplicationContext()).getAlContato();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClickbSalvar(View view) {
        EditText etNome = (EditText) findViewById(R.id.etNome);
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etTelefone = (EditText) findViewById(R.id.etTelefone);
       Planta planta = new Planta(etNome.getText().toString(), etTelefone.getText().toString(), 30,05,1994, etEmail.getText().toString());
        alPlantas.add(planta);
        this.finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}