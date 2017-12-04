package com.example.aluno.daybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aluno.daybook.BancoOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class LembreteDAO {
    private SQLiteDatabase bd;
    private BancoOpenHelper openHelper;

    public LembreteDAO(Context contexto){
        openHelper=new BancoOpenHelper(contexto);

    }

    public void abrir(){
        bd = openHelper.getWritableDatabase();
    }

    public void fechar(){
        bd.close();
    }

    public Lembrete criarLembrete(String nomeLembrete, String descricao){
        ContentValues valores = new ContentValues();
        valores.put("descricao", descricao);
        valores.put("nome", nomeLembrete);
        long id = bd.insert("itens", null, valores);
        Lembrete item = new Lembrete();
        item.setId(id);
        item.setDescricao(descricao);
        item.setNomeLembrete(nomeLembrete);
        return item;
    }
    public void removerLembrete(Lembrete item){
        long id = item.getId();
        bd.delete("Itens", "id=" +id, null);
    }

    public List<Lembrete> lerItens(){
        List<Lembrete> itens = new ArrayList<>();
        Cursor cursor = bd.query("itens", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            Lembrete i = new Lembrete();
            i.setId(cursor.getInt(0));
            i.setDescricao(cursor.getString(0));
            itens.add(i);
        }
        cursor.close();
        return itens;
    }
}
