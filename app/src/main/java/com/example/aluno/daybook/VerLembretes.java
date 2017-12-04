package com.example.aluno.daybook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class VerLembretes extends Activity {

    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ver_lembretes);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("");

        ListView listaLembretes = (ListView) findViewById(R.id.lista);
        ArrayAdapter<Lembrete> adapter = new ArrayAdapter<Lembrete>(this, android.R.layout.simple_list_item_1);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, TelaPrincipal.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }







        }

