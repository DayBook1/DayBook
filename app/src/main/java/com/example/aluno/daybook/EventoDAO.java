package com.example.aluno.daybook;

import android.app.usage.UsageEvents;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    private SQLiteDatabase bd;
    private BancoOpenHelper openHelper;

    public EventoDAO(Context contexto){
        openHelper=new BancoOpenHelper(contexto);

    }

    public void abrir(){
        bd = openHelper.getWritableDatabase();
    }

    public void fechar(){
        bd.close();
    }

    public Evento criarEvento(String descricao, String nomeEvento, RadioGroup opcoes){
        ContentValues valores = new ContentValues();
        valores.put("nomeEvento", nomeEvento);
        valores.put("descricao", descricao);
        valores.put("opcoes", String.valueOf(opcoes));
        long id = bd.insert("itens", null, valores);
        Evento item = new Evento();
        item.setId(id);
        item.setNomeEvento(nomeEvento);
        item.setDescricao(descricao);
        item.setOpcoes(opcoes);

        return item;
    }
    public void removerEvento(Evento item){
        long id = item.getId();
        bd.delete("Itens", "id=" +id, null);
    }

    public List<Evento> lerEvento(){
        List<Evento> itens = new ArrayList<>();
        Cursor cursor = bd.query("itens", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            Evento i = new Evento();
            i.setId(cursor.getInt(0));
            i.setNomeEvento(cursor.getString(0));
            i.setDescricao(cursor.getString(0));

            itens.add(i);
        }
        cursor.close();
        return itens;
    }
}
