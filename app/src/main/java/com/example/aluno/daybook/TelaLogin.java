package com.example.aluno.daybook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends Activity {


    private EditText emailLogin;
    private EditText senhaLogin;
    private Button buttonLogin, btCad, btEsq;
    //private boolean loggedIn = false;
    //private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailLogin = (EditText)findViewById(R.id.txtEmailLogin);
        senhaLogin = (EditText)findViewById(R.id.txtSenhaLogin);
        buttonLogin = (Button) findViewById(R.id.btLoginLog);

        btCad = (Button) findViewById(R.id.btCadastrar);
        btEsq = (Button) findViewById(R.id.btRdqueceusenha);

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaLogin.this, TelaPrincipal.class);
                startActivity(it);

            }
        });

        btEsq.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(it);
            }
        });

    }
}