package com.example.aluno.daybook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class TelaPrincipal extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("");
    }

    @SuppressLint("NewApi")
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, TelaLogin.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }
    public void addNovo(View view){
        Intent it = new Intent(this, AdicionarItem.class);
        startActivity(it);
    }

    public void verLembretes(View view){
        Intent it = new Intent(this, VerLembretes.class);
        startActivity(it);
    }
    public void verEventos(View view){
        Intent it = new Intent(this, VerEventos.class);
        startActivity(it);
    }
    public void VerMaterias(View view){
        Intent it = new Intent(this, VerMaterias.class);
        startActivity(it);
    }

    public void sair(View view){
        Intent it = new Intent(this, MainActivity.class);
        finish();
        startActivity(it);
    }
}
