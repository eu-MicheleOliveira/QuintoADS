package com.example.alunos.tarefas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Tarefa> listaTarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listaTarefas);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //permite  a marcação ("check") de multiplas linhas
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaTarefas.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }


    public void adicionar(View view) {
        EditText edetDescricao = (EditText) findViewById(R.id.edtDesc);
        EditText edetdata = (EditText) findViewById(R.id.data);

        String valorDesc = edetDescricao.getText().toString();
        String data = edetdata.getText().toString();

        Tarefa item = new Tarefa();

        item.setDescricao(valorDesc);
        item.setData(data);

        listaTarefas.add(item);
        adapter.notifyDataSetChanged();


        edetDescricao.setText("");
        edetdata.setText("");

        edetDescricao.requestFocus();
    }
}

