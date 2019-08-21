package com.example.alunos.listadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

         private ArrayList<Item> listaDeItens = new ArrayList<>();
         private ArrayAdapter<Item> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaDeItens);

            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
    }

    public void adicionar (View view){
        EditText edtDesc = (EditText) findViewById(R.id.edtDesc);
        EditText edtQtd = (EditText) findViewById(R.id.edtQtd);

        String valorDesc = edtDesc.getText().toString();
        String valorQtd = edtQtd.getText().toString();

        Item item = new Item();
        item.setDescricao(valorDesc);
        item.setQuantidade(new Integer(valorQtd));

        listaDeItens.add(item);


        //notificamos o adapter que houve uma alteração nos
        //dados para que ele atualize ("refresh") a visão
        adapter.notifyDataSetChanged();

        //Limpamos o conteúdo dos campos para o usuário
        //digitar os valores do próximo item

        edtDesc.setText("");
        edtQtd.setText("");

        //posicinamos o cursor (o foco) no primeiro Edit

        edtDesc.requestFocus();
    }
}
