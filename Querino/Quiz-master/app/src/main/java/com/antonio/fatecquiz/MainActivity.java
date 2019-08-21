package com.antonio.fatecquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuizDAO dao;
    private ListView listView;
    private PerguntasAdapter perguntasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        dao = new QuizDAO(this);
        List<Pergunta> perguntas = dao.buscaPerguntas();

        listView = findViewById(R.id.main_list_view);

        perguntasAdapter = new PerguntasAdapter(this, perguntas);
        listView.setAdapter(perguntasAdapter);
    }
}
