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

    public String getDescricao(){
        return descricao.toUpperCase();
    }


    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            this.quantidade = 1;

        }
    }
    public int getQuantidade(){
        return quantidade;

        //KISS: Keep It Simple, Stupid
    }

    public String toString(){

        return descricao + "\n"
                + "Quantidade: " + quantidade;
    }

}