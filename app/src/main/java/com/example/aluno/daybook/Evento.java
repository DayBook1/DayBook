package com.example.aluno.daybook;

import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Aluno on 14/11/2017.
 */

public class Evento {
    private long id;
    private String nomeEvento;
    private RadioGroup opcoes;
    private String descricao;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
    public String getNomeEvento(){
        return nomeEvento;
    }
    public RadioGroup getOpcoes(){return opcoes; }
    public String getDescricao(){
        return descricao;
    }

    public void setNomeEvento(String nomeEvento){
        this.nomeEvento = nomeEvento;
    }
    public void setOpcoes(RadioGroup opcoes){ this.opcoes = opcoes; }
    public void setDescricao(String descricao){ this.descricao = descricao; }

    @Override
    public String toString(){
        return nomeEvento;

    }
}
