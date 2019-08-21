package com.example.alunos.listadecompras;

public class Item {

    private String descricao;
    private int qtd;

    public void setDescricao (String descricao){
        if(!descricao.isEmpty()){
            this.descricao = descricao;
        }else{
            this.descricao = "Indefinido";
        }
    }

    public void setQtd (int qtd){
        if(qtd > 0){
            this.qtd = qtd;
        }else{
            this.qtd = 1;
        }
    }

    public String getDescricao() {

        return descricao.toUpperCase();
    }

    public int getQtd() {
        return qtd;
    }

    public String toString(){

        return descricao + "\n" + "Quantidade: " + qtd;
    }

}
