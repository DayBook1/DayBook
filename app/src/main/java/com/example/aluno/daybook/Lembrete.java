package com.example.aluno.daybook;

public class  Lembrete {
        private long id;
        private String nomeLembrete;
        private String descricao;

        public long getId(){
            return id;
        }

        public void setId(long id){
            this.id = id;
        }
        public String getNomeLembrete() { return nomeLembrete;  }
        public String getDescricao(){
            return descricao;
        }

        public void setNomeLembrete(String nomeLembrete){
        this.nomeLembrete = this.nomeLembrete;
    }
        public void setDescricao(String descricao){
            this.descricao = descricao;
        }

        @Override
        public String toString(){
            return descricao;
        }
}


