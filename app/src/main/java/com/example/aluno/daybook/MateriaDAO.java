package com.example.aluno.daybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 13/11/2017.
 */

public class MateriaDAO {
    private SQLiteDatabase bd;
    private BancoOpenHelper openHelper;

    public MateriaDAO(Context contexto){
        openHelper=new BancoOpenHelper(contexto);

    }

    public void abrir(){
        bd = openHelper.getWritableDatabase();
    }

    public void fechar(){
        bd.close();
    }

    public Lembrete criarMateria(String descricao){
        ContentValues valores = new ContentValues();
        valores.put("descricao", descricao);
        long id = bd.insert("itens", null, valores);
        Lembrete item = new Lembrete();
        item.setId(id);
        item.setDescricao(descricao);
        return item;
    }
    public void removerMateria(Materia item){
        long id = item.getId();
        bd.delete("Itens", "id=" +id, null);
    }

    public List<Materia> lerMateria(){
        List<Materia> itens = new ArrayList<>();
        Cursor cursor = bd.query("itens", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            Materia i = new Materia();
            i.setId(cursor.getInt(0));
            i.setNomeMateria(cursor.getString(0));
            i.setNomeProfessor(cursor.getString(0));
            itens.add(i);
        }
        cursor.close();
        return itens;
    }
}
