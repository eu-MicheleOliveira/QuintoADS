package com.example.alunos.listadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> listaItens = new ArrayList<>();
    private ArrayAdapter<Item> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listaItens);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //permite  a marcação ("check") de multiplas linhas
         listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    public  void adicionar(View view){

        EditText edetDescricao = (EditText)findViewById(R.id.edetDescricao);
        EditText edetQtd       = (EditText)findViewById(R.id.edetQtd);

        String valorDesc  = edetDescricao.getText().toString();
        String valorQtd   = edetQtd.getText().toString();

        Item item = new Item();

        item.setDescricao(valorDesc);
        item.setQtd(Integer.parseInt(valorQtd));

        listaItens.add(item);

        //notificamos o adapte que houve uma alteração nos dados para que ele atualize a visão
        adapter.notifyDataSetChanged();

        edetDescricao.setText("");
        edetQtd.setText("");

        //deixando o campo descrição com foco após limpar os campos
        edetDescricao.requestFocus();

    }

}
