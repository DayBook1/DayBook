package com.example.aluno.daybook;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import static android.R.attr.id;

/**
 * Created by Aluno on 28/11/2017.
 */

public class ConsultaLembretes extends Activity {
    private ListView lista;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_lembretes);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{ BancoOpenHelper.NOME, BancoOpenHelper.DESCRICAO};
        int[] idViews = new int[] {R.id.nomeLembrete, R.id.descricaoLembrete};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_lembretes, cursor, nomeCampos, idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(BancoOpenHelper.NOME));
                Intent intent = new Intent(ConsultaLembretes.this, AlteraLembretes.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}
