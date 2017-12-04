package com.example.aluno.daybook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AdicionarItem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, TelaPrincipal.class));
                finish();
                break;
                default:break;
        }
        return true;
    }

    public void irAdicionarEvento(View view){
        Intent it = new Intent(this, AdicionarEvento.class);
        startActivity(it);
    }

    public void irAdicionarMateria(View view){
        Intent it = new Intent(this, AdicionarMateria.class);
        startActivity(it);
    }

    public void irAdicionarLembrete(View view){
        Intent it = new Intent(this, AdicionarLembrete.class);
        startActivity(it);
    }



}
