package com.example.alunos.listadetarefas;

import android.content.Context;
import android.database.Cursor;
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
    public void abrir(){
        db = bancoOpenHelper.getWritableDatabase();
    }

    //Devemos chamar o método fechar() após utilizar o banco para liberar recursos do sistema operacional
    public  void fechar(){
        db.close();
    }

             //create(C)
    public void incluirTarefa(Tarefa tarefa){

    }
            //Read(R)
            //
            //
      public ArrayList<Tarefa> listarTarefas()
            {
                ArrayList<Tarefa> tarefas = new ArrayList<>();
                abrir();

                //1. Após abrir o banco, fazemos uma consulta de todas as tarefas
                // tarefas cadastradas na tabela "tarefas' e guardamos os resultado  em um objeto da classe CURSOR
                    //COmando SQL equivalente: SELECT * from tarefas;
                Cursor resultado = db.query("tarefas", null, null, null, null,null,null);
                //Usando um laço (while), percorremos os registros de tarefa um de cada vez, do primeiro ao ultimo
                   while (resultado.moveToNext()){
                       //3.Instanciamos um objeto da classe Tarefa 'vazio'
                       Tarefa tarefa = new Tarefa();
                       //4 . Colocamos no objeto 'tarefa', como sua 'descriçao' o valor existente no campo 'descricao ' da tarefa na tabela do banco de dados.

                       tarefa.setDescricao(resultado.getString( resultado.getColumnIndex("descricao")));

                       //5. Fazemos o mesmo para data
                       tarefa.setData(resultado.getString(resultado.getColumnIndex("data")));

                       //6. Objecto PRONTO! Adicionamos o mesmo ao vetor "tarefas"
                       tarefas.add(tarefa);
                   }

                fechar();
                return tarefas;
            }
            //Update (U)
      public void alterarTarefa(Tarefa tarefa){

            }
            //Deletar (D)
      public boolean excluirTarefa(Tarefa tarefa){

                 return true;
             }


}
