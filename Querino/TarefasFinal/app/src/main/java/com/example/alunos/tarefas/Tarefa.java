package com.example.alunos.tarefas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Tarefa {

    private String descricao;
    private Date data;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);

    public void setData(String data) {
        try {
            this.data = dateFormat.parse(data);
        } catch (ParseException e) {
            this.data = new Date();
        }
    }

    public void setDescricao(String descricao) {
        if (!descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            this.descricao = "Indefinido";
        }
    }

    public String getData() {
        return dateFormat.format(data);
    }

    public String getDescricao() {

        return descricao.toUpperCase();
    }

    private long diasParaTarefa() {
        Date hoje = null;
        try {
            hoje = dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            hoje = new Date();
        }
        long diferencaEmMilisegundos = data.getTime() - hoje.getTime();
        long diferencaEmDias = TimeUnit.DAYS.convert(diferencaEmMilisegundos, TimeUnit.MILLISECONDS);
        return diferencaEmDias;

    }

    public String toString() {
        String prazo = "HOJE";
        long dias = diasParaTarefa();

        if (dias > 0) {
            prazo = "Daqui a " + dias + "dia(s)";
        } else if (dias < 0) {
            dias = -dias;
            prazo = "ATRASADA EM " + dias + "DIAS";
        }
        return descricao + "\n" + getData() + "" + prazo;
    }
}


