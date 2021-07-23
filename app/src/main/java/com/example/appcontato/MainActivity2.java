package com.example.appcontato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Adicionar Planta");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.addmenu,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // item será um dos elementos do menu criados no layout menu_main.xml
        int id = item.getItemId();

        switch (id) {
            case R.id.item:
                startActivity(new Intent(MainActivity2.this, MainActivity.class));

                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}