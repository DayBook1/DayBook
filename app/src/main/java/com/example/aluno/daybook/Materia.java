package com.example.aluno.daybook;



public class Materia {
        private long id;
        private String nomeMateria;
        private String nomeProfessor;
        private String emailProfessor;

        public long getId(){
            return id;
        }

        public void setId(long id){
            this.id = id;
        }
        public String getNomeMateria(){
            return nomeMateria;
        }
        public String getNomeProfessor(){
        return nomeProfessor;
    }
        public String getEmailProfessor(){
        return emailProfessor;
    }

        public void setNomeMateria(String nomeMateria){
            this.nomeMateria = nomeMateria;
        }
        public void setNomeProfessor(String nomeProfessor){
        this.nomeProfessor = nomeProfessor;
    }
        public void setEmailProfessor(String emailProfessor){ this.emailProfessor = emailProfessor; }

        @Override
        public String toString(){
            return nomeMateria;

        }
    }



