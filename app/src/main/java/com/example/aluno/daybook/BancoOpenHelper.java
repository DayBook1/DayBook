package com.example.aluno.daybook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BancoOpenHelper extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "lembretes";
    public static final String TAB_MATERIA = "materias";
    public static final String TAB_EVENTOS = "eventos";
    public static final String NOME = "nome";
    public static final String DESCRICAO = "_descricao";
    public static final String NOME_PROF = "nomeProf";
    public static final String NOME_MATERIA = "nomeMateria";
    public static final String EMAIL_PROF = "emailProf";
    public static final String NOME_EVENTO = "nomeEvento";
    public static final String DESCRICAO_EVENTO = "descricaoEvento";
    public static final String USUARIO = "usuario";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    public static final String CADASTRO = "cadastro";
    public static final String NOME_PESSOA = "nomePessoa";
    public static final String SOBRENOME_PESSOA = "sobrenomePessoa";


    private static final int VERSAO = 1;

    public BancoOpenHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "("
                + NOME + " text,"
                + DESCRICAO + " text"
                + ")";
        db.execSQL(sql);

        String sql_materia = "CREATE TABLE " + TAB_MATERIA + "("
                + NOME_MATERIA + " text, "
                + NOME_PROF + " text, "
                + EMAIL_PROF + " text"
                + ")";
        db.execSQL(sql_materia);

        String sql_evento = "CREATE TABLE " + TAB_EVENTOS + "("
                + NOME_EVENTO + " text, "
                + DESCRICAO_EVENTO + " text"
                + ")";
        db.execSQL(sql_evento);


        String sql_usuario = "CREATE TABLE " + USUARIO + "("
                + EMAIL + " text,"
                + SENHA + " text"
                + ")";
        db.execSQL(sql_usuario);

        String sql_cadastro = "CREATE TABLE "+CADASTRO+"("
                + NOME_PESSOA + " text,"
                + SOBRENOME_PESSOA + " text,"
                + EMAIL + " text,"
                + SENHA + " text "
                +")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " +TABELA);
        db.execSQL("DROP TABLE IF EXISTS " +TAB_EVENTOS);
        db.execSQL("DROP TABLE IF EXISTS " +TAB_MATERIA);
        onCreate(db);
    }
}
