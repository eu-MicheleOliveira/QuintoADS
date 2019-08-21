package com.example.alunos.listadecompras;

public class Item {


    private String descricao;
    private int quantidade;

    public void setDescricao(String descricao) {
        if (!descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            this.descricao = "INDEFINIDO";
        }
    }

    public void getQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            this.quantidade = 1;

        }
    }

}