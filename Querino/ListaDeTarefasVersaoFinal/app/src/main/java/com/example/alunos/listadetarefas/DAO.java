package com.example.alunos.listadetarefas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {


    //Este objeto PRIVADO vai ser usado internamente pela DAO para criação automatica (se necessaria) e abertura do banco
    private  BancoOpenHelper bancoOpenHelper;

    //Este outro objeto PRIVADO chamado 'db' servirá para executarmos comandos SQL no nosso banco SQLIte
    private SQLiteDatabase db;

    public DAO (Context context){
        bancoOpenHelper = new BancoOpenHelper(context,"banco.db", null,1);
    }

             //create(C)
             public void incluirTarefa(Tarefa tarefa){

            }
            //Read(R)
            public ArrayList<Tarefa> listarTarefas()
            {
                return null;
            }
            //Update (U)
            public void alterarTarefa(Tarefa tarefa){

            }
            //Deletar (D)
             public boolean excluirTarefa(Tarefa tarefa){

                 return true;
             }


}
