package com.example.aluno.daybook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

/**
 * Created by Aluno on 28/11/2017.
 */

public class BancoController {
    private SQLiteDatabase db;
    private BancoOpenHelper banco;

    public BancoController(Context context) {
        banco = new BancoOpenHelper(context);
    }

    public String insereDado(String nome, String descricao) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoOpenHelper.NOME, nome);
        valores.put(BancoOpenHelper.DESCRICAO, descricao);

        resultado = db.insert(BancoOpenHelper.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";

        else
            return "Registro Inserido com sucesso";
    }

    public String insereDadoMateria(String nomeMat, String nomeProf, String email) {
            ContentValues valores;
            long resultado;

            db = banco.getWritableDatabase();
            valores = new ContentValues();
            valores.put(BancoOpenHelper.NOME_MATERIA, nomeMat);
            valores.put(BancoOpenHelper.NOME_PROF, nomeProf);
            valores.put(BancoOpenHelper.EMAIL_PROF, email);

            resultado = db.insert(BancoOpenHelper.TAB_MATERIA, null, valores);
            db.close();

            if (resultado == -1)
            return "Erro ao inserir registro";

        else
            return "Registro Inserido com sucesso";
    }

    public String insereDadoEvento(String nomeEv, String descricaoEv) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoOpenHelper.NOME_EVENTO, nomeEv);
        valores.put(BancoOpenHelper.DESCRICAO_EVENTO, descricaoEv);


        resultado = db.insert(BancoOpenHelper.TAB_EVENTOS, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";

        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {banco.NOME, banco.DESCRICAO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosMateria() {
        Cursor cursor;
        String[] campos = {banco.NOME_MATERIA, banco.NOME_PROF, banco.EMAIL_PROF};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TAB_MATERIA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosEvento() {
        Cursor cursor;
        String[] campos = {banco.NOME_EVENTO, banco.DESCRICAO_EVENTO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TAB_EVENTOS, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(String nome) {
        Cursor cursor;
        String[] campos = {banco.NOME, banco.DESCRICAO};
        String where = BancoOpenHelper.NOME + "=" + nome;
        db = banco.getReadableDatabase();
        cursor = db.query(BancoOpenHelper.TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoMateriaById(String nome) {
        Cursor cursor;
        String[] campos = {banco.NOME_MATERIA, banco.NOME_PROF, banco.EMAIL_PROF};
        String where = BancoOpenHelper.NOME_MATERIA + "=" + nome;
        db = banco.getReadableDatabase();
        cursor = db.query(BancoOpenHelper.TAB_MATERIA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoEventoById(String nome) {
        Cursor cursor;
        String[] campos = {banco.NOME_EVENTO, banco.DESCRICAO_EVENTO};
        String where = BancoOpenHelper.NOME_EVENTO + "=" + nome;
        db = banco.getReadableDatabase();
        cursor = db.query(BancoOpenHelper.TAB_EVENTOS, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(String nome, String descricao){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = BancoOpenHelper.NOME + "=" + nome;

        valores = new ContentValues();
        valores.put(BancoOpenHelper.NOME, nome);
        valores.put(BancoOpenHelper.DESCRICAO, descricao);

        db.update(BancoOpenHelper.TABELA, valores, where, null);
        db.close();

    }

    public void alteraRegistroMateria(String nome, String nomeProf, String email){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = BancoOpenHelper.NOME_MATERIA + "=" + nome;

        valores = new ContentValues();
        valores.put(BancoOpenHelper.NOME_MATERIA, nome);
        valores.put(BancoOpenHelper.NOME_PROF, nomeProf);
        valores.put(BancoOpenHelper.EMAIL_PROF, email);

        db.update(BancoOpenHelper.TAB_MATERIA, valores, where, null);
        db.close();

    }

    public void alteraRegistroEvento(String nome, String descricao){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = BancoOpenHelper.NOME_EVENTO + "=" + nome;

        valores = new ContentValues();
        valores.put(BancoOpenHelper.NOME_EVENTO, nome);
        valores.put(BancoOpenHelper.DESCRICAO_EVENTO, descricao);


        db.update(BancoOpenHelper.TAB_EVENTOS, valores, where, null);
        db.close();

    }


    public void deletaRegistro(String nome){
        String where = BancoOpenHelper.NOME + "=" + nome;
        db = banco.getReadableDatabase();
        db.delete(BancoOpenHelper.TABELA,where,null);
        db.close();
    }

    public void deletaRegistroMateria(String nome){
        String where = BancoOpenHelper.NOME_MATERIA + "=" + nome;
        db = banco.getReadableDatabase();
        db.delete(BancoOpenHelper.TAB_MATERIA,where,null);
        db.close();
    }

    public void deletaRegistroEventos(String nome){
        String where = BancoOpenHelper.NOME_EVENTO + "=" + nome;
        db = banco.getReadableDatabase();
        db.delete(BancoOpenHelper.TAB_EVENTOS,where,null);
        db.close();
    }


}


