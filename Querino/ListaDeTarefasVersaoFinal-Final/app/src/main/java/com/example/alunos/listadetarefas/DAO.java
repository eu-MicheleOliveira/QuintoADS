package com.example.alunos.listadetarefas;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class DAO {

    //usado para a criação automática e abertura no banco
    private BancoOpenHelper bancoOpenHelper;

    //servirá para executar comandos sql no banco
    private SQLiteDatabase db;

    //instanciando o banco na classe DAO
    public DAO(Context context){
        bancoOpenHelper = new BancoOpenHelper(context, "namco.db", null, 1);
    }

    //método para abrir o banco de dados
    public void abrir() {
        db = bancoOpenHelper.getWritableDatabase();
    }

    //método para fechar o banco de dados
    public void fechar(){
        db.close();
    }

             //create(C)
             public int incluirTarefa(Tarefa tarefa){

                  //1 - abra o banco de dados
                 abrir();

                 //2 - instanciamos um objeto da classe ContentValues
                 //que será uadaos para mapear os atributos do objeto tarefa
                 //para os campos da tabela tarefa
                 ContentValues contentValues = new ContentValues();

                 //3 - fazemos o mapeamento de um vaor para um campo da tabela
                 //usando o métofdo put do objeto contentValue
                 //passamos para este método dois parametros
                 // o primeiro é uma string com o nome da tabela
                 // e o segundo é o respectivo valor para este campo
                 contentValues.put("descricao", tarefa.getDescricao());
                 contentValues.put("data", tarefa.getData());

                 //fazemos o mesmo para o id - esta linha está dando erro pois falta parte do código
                 tarefa.setId(resultado.getInt(resultado.getColumnIndex("_id")));

                 //4 - executamos então o métoo insert do objeto db.
                 // para este método passamos três parametros
                 // - uma string com o nome da atabela onde será feita a inclusão
                 // - null (não usaremos o nullColumnnHack
                 // objeto da classe content values cmo os valores para os campos
                 int id = (int)db.insert("tarefas", null, contentValues);

                 //fecha o banco de dados
                 fechar();

                 return id;

            }
            //Read(R)
            public ArrayList<Tarefa> listarTarefas()
            {
                ArrayList<Tarefa> tarefas = new ArrayList<>();

                abrir();
                //realizando consulta no banco
                Cursor resultado = db.query("tarefas",
                        null, null, null,
                        null, null, null);

                //percorrendo os registros da tabela tarefa
                while(resultado.moveToNext()){

                    //instanciando um objeto da classe tarefa vazio
                    Tarefa tarefa = new Tarefa();

                    //colocando o objeto "tarefa" no campo descricao
                    tarefa.setDescricao(resultado.getString(resultado.getColumnIndex("descricao")));

                    //Fazer o mesmo para a data
                    tarefa.setData(resultado.getString(resultado.getColumnIndex("data")));

                    //adicioanndo o objeto na lista
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

                abrir();
                //excluir dados na tebela pelo id
                int resp = db.delete("tarefas", "_id = " + tarefa.getId(), null);

                fechar();

                //retorna verdadeiro ou false
                return resp > 0 ? true : false;

                 return false;
             }

}
