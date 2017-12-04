package com.example.aluno.daybook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarLembrete extends Activity {

    EditText desc;
    EditText nomelemb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_lembrete);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("");

        Button btAddLembrete = (Button) findViewById(R.id.btAddLembrete);
        btAddLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome;
                String descricao;
                desc = (EditText) findViewById(R.id.emailProfessor);
                nomelemb = (EditText) findViewById(R.id.nomeProfessorTxt);


                nome = nomelemb.toString();
                descricao = desc.toString();

                BancoController banco = new BancoController(AdicionarLembrete.this);
                String aviso = banco.insereDado(nome, descricao);

                Toast.makeText(AdicionarLembrete.this, aviso, Toast.LENGTH_LONG).show();
            }
        });
    }

    @SuppressLint("NewApi")
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, AdicionarItem.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

}


