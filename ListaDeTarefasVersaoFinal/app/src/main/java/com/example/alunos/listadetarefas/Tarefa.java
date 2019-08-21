package com.example.alunos.listadetarefas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Tarefa {
    private DateFormat formata = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
    private String descricao;
    private Date data;

    public void setDescricao(String descricao){
        if(!descricao.isEmpty()){
            this.descricao = descricao;
        }else{
            this.descricao = "INDEFINIDO";
        }

    }
    public String getDescricao() {
        return descricao;
    }

     public void setData (String dataStr){
        try{
            this.data = formata.parse(dataStr);
        }catch (ParseException ex){
            this.data = new Date();
        }

     }

    public String getData() {
        return formata.format(data);
    }

    private long diasParaTarefa(){
        Date hoje = null;
        try{
            hoje = formata.parse(formata.format(new Date()));
        } catch (ParseException e){
            hoje = new Date();
        }
        long diferencaEmMilisegundos = data.getTime() - hoje.getTime();
        long diferencaEmDias= TimeUnit.DAYS.convert(diferencaEmMilisegundos,
                TimeUnit.MILLISECONDS);
        return diferencaEmDias;
    }

    @Override
    public String toString(){
        String prazo = "HOJE";
        long dias = diasParaTarefa();
        if (dias > 0){
            prazo = "Daqui a " + dias + " dia(s)";
        }else if ( dias < 0){
            dias = -dias;
            prazo = "ATRASADA EM " + dias + " DIA(S)";
        }
        return descricao + "\n" +
                getData() + " " + prazo;
    }
}
