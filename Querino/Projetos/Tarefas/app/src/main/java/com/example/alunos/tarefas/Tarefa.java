package com.example.alunos.tarefas;

public class Tarefa {

    private String descricao;
    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        if (!descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            this.descricao = "Indefinido";
        }
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao.toUpperCase();
    }

    public String toString() {

        return descricao + "\n" + "Data: " + data;
    }
}




