package com.example.aluno.daybook;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Aluno on 28/11/2017.
 */

public class AlteraLembretes extends Activity {
    EditText nome;
    EditText descricao;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    protected void onCreate(Bundle savedInstanceSaved) {
        super.onCreate(savedInstanceSaved);
        setContentView((R.layout.activity_alterar_lembrete));

        codigo = this.getIntent().getStringExtra(("codigo"));

        crud = new BancoController(getBaseContext());

        nome = (EditText) findViewById(R.id.textView13);
        descricao = (EditText) findViewById(R.id.editText14);

        alterar = (Button) findViewById((R.id.button19));

        cursor = crud.carregaDadoById(codigo);
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(BancoOpenHelper.NOME)));
        descricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(BancoOpenHelper.DESCRICAO)));


        alterar.setOnClickListener(new OnClickListener(){
            public void onClick (View v){
                crud.alteraRegistro(nome.getText().toString(), descricao.getText().toString());
                //Intent intent = new Intent(AlteraLembretes.this, ConsultaLembretes.class);
                //startActivity(intent);
                //finish();
            }
        });



        deletar = (Button)findViewById(R.id.button20);
        deletar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(codigo);
                Intent intent = new Intent(AlteraLembretes.this,ConsultaLembretes.class);
                startActivity(intent);
                finish();
            }
        });

    }



}


