package com.example.alunos.listadetarefas;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Tarefa> listaDeItens;
    private ArrayAdapter<Tarefa> Adapter;

    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //início do trecho de uso do banco de dados
        dao = new DAO(this);
        listaDeItens = dao.listarTarefas();
        //fim do trecho de uso de banco de dados

        listaDeItens = new ArrayList<>();

        Adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listaDeItens);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(Adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaDeItens.remove(position);
                Adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
    public void adicionar(View view){
        EditText edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        EditText edtData = (EditText) findViewById(R.id.edtData);

        String valorDescricao = edtDescricao.getText().toString();
        String valorData = edtData.getText().toString();

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(valorDescricao);
        DateFormat formata = new SimpleDateFormat("dd/MM/yyyy");

        tarefa.setData(valorData);
        //início do trecho do acesso ao banco de dados
        int id =  dao.incluirTarefa(tarefa);
        //fim do trecho ao banco de dados

        tarefa.setId(id);

        listaDeItens.add(tarefa);
        Adapter.notifyDataSetChanged();

        edtDescricao.setText("");
        edtData.setText("");

        edtDescricao.requestFocus();
    }

}


