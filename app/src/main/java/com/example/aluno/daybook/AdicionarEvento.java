
package com.example.aluno.daybook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdicionarEvento extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evento);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setTitle("");

        Button btAddEvento = (Button) findViewById(R.id.btAddEvento);
        btAddEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome;
                int tipo;
                String descricao;

                EditText txtNome = (EditText) findViewById(R.id.nomeEventoTxt);
                RadioGroup rgTipo= (RadioGroup) findViewById(R.id.RadioGroup);
                EditText txtDescricao = (EditText) findViewById(R.id.addDescricaoTxt);

                nome = txtNome.toString();
                tipo = rgTipo.getCheckedRadioButtonId();
                descricao = txtDescricao.toString();

                BancoController banco = new BancoController(AdicionarEvento.this);
                String aviso = banco.insereDadoEvento(nome, descricao);

                Toast.makeText(AdicionarEvento.this, aviso, Toast.LENGTH_LONG).show();
            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, AdicionarItem.class));

                break;
            default:break;
        }
        return true;
    }
}