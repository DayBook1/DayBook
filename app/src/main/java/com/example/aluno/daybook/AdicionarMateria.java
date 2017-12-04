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

public class AdicionarMateria extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("");

        Button btAddMateria = (Button) findViewById(R.id.btAddMateria);
        btAddMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome;
                String nomeProfessor;
                String emailProfessor;

                EditText txtNome = (EditText) findViewById(R.id.emailProfessor);
                EditText txtNomeProfessor = (EditText) findViewById(R.id.nomeProfessorTxt);
                EditText txtEmailProfessor = (EditText) findViewById(R.id.emailProfessor);


                nome = txtNome.toString();
                nomeProfessor = txtNomeProfessor.toString();
                emailProfessor = txtEmailProfessor.toString();

                BancoController banco = new BancoController(AdicionarMateria.this);
                String aviso = banco.insereDadoMateria(nome, nomeProfessor, emailProfessor);

                Toast.makeText(AdicionarMateria.this, aviso, Toast.LENGTH_LONG).show();
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



