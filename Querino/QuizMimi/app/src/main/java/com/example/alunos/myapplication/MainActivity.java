package com.example.alunos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int PerguntasErradas = 0, perguntasCorretas = 0;
    private ArrayList<Pergunta> perguntas;
    private ArrayAdapter<Pergunta> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perguntas = new ArrayList<>();

        QuizDAO repository = new QuizDAO(this);
        perguntas = repository.GetPerguntas();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, perguntas);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                Pergunta pergunta = perguntas.get(posicao);
                if (!pergunta.isRespondido()){
                    pergunta.setRespondido(true);
                    abrirActivityPergunta(posicao);
                    adapter.notifyDataSetChanged();
                } else {
                    toasty("Pergunta ja foi respondida");
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        QuizDAO repository = new QuizDAO(this);
        switch (item.getItemId()) {
            case R.id.excluir:
                repository.excluir();
                refreshLista();
                atualizaPlacar(0,0);
                toasty("Resetado");
                break;
            case R.id.totPerguntas:
                toasty("Total Perguntas Cadastradas: ");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private double percentualAcertos(){
        QuizDAO repository = new QuizDAO(this);
        perguntas = repository.GetPerguntas();
        double count = perguntasCorretas + PerguntasErradas;

        return (perguntasCorretas /count)*100;
    }

    private int totalPerguntasCadastradas(){
        QuizDAO repository = new QuizDAO(this);
        perguntas = repository.GetPerguntas();
        return perguntas.size();
    }

    private void refreshLista(){
        QuizDAO repository = new QuizDAO(this);
        perguntas = repository.GetPerguntas();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, perguntas);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void toasty(String mensagem){
        Toast.makeText(this,mensagem,Toast.LENGTH_LONG).show();
    }

    public void abrirActivityPergunta(int position){
        Intent intent = new Intent(this,PerguntaActivity.class);

        Pergunta pergunta = new Pergunta();
        QuizDAO repository = new QuizDAO(this);
        pergunta = repository.getPergunta(position);

        intent.putExtra("perguntas", pergunta);

        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            if (requestCode == 0) {
                boolean repostaCorreta = data.getBooleanExtra("acertou", false);

                if (repostaCorreta) {
                    perguntasCorretas++;
                } else {
                    PerguntasErradas++;
                }
                atualizaPlacar(PerguntasErradas, perguntasCorretas);

            }
        }
        if (requestCode == 1) {
            QuizDAO repository = new QuizDAO(this);
            perguntas = repository.GetPerguntas();
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, perguntas);
            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
            perguntasCorretas = 0;
            PerguntasErradas = 0;
            atualizaPlacar(0,0);
            adapter.notifyDataSetChanged();
        }

    }

    public void IncluirPergunta(View view){
        Intent intent = new Intent(this,AdicionarPerguntaActivity.class);
        startActivityForResult(intent,1);
        //startActivity(intent);
    }

    private void atualizaPlacar(int erros, int acertos){
        TextView txtAcertos = (TextView) findViewById(R.id.txtAcertos);
        TextView txtErros = (TextView) findViewById(R.id.txtErros);

        txtAcertos.setText("Acertos: " + acertos);
        txtErros.setText("Erros: " + erros);
    }
}
