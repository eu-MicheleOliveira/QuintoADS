package com.example.alunos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class PerguntaActivity extends AppCompatActivity {

    private Pergunta pergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        setTitle("Perguntas");

        RadioButton alternativaA = (RadioButton) findViewById(R.id.altA);
        RadioButton alternativaB = (RadioButton) findViewById(R.id.altB);
        RadioButton alternativaC = (RadioButton) findViewById(R.id.altC);
        RadioButton alternativaD = (RadioButton) findViewById(R.id.altD);

        Intent intent = getIntent();
        pergunta = (Pergunta) intent.getSerializableExtra("perguntas");

        alternativaA.setText(pergunta.getAltA());
        alternativaB.setText(pergunta.getAltB());
        alternativaC.setText(pergunta.getAltC());
        alternativaD.setText(pergunta.getAltD());
    }

    public void responder(View view) {
        int idRespostaCorreta = 0;
        boolean acertou = false;

        String ok = pergunta.getAltCorreta();

        if (ok.equalsIgnoreCase(pergunta.getAltA())) {
            idRespostaCorreta = R.id.altA;
        } else if (ok.equalsIgnoreCase(pergunta.getAltB())) {
            idRespostaCorreta = R.id.altB;
        } else if (ok.equalsIgnoreCase(pergunta.getAltC())) {
            idRespostaCorreta = R.id.altC;
        } else if (ok.equalsIgnoreCase(pergunta.getAltD())) {
            idRespostaCorreta = R.id.altD;
        }

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        if (radioGroup.getCheckedRadioButtonId() == idRespostaCorreta) {
            Toast.makeText(this, "Resposta certa!", Toast.LENGTH_LONG).show();
            acertou = true;
        } else {
            Toast.makeText(this, "Resposta errada!", Toast.LENGTH_LONG).show();
        }
        Intent it = new Intent();

        it.putExtra("acertou", acertou);
        setResult(RESULT_OK, it);

        finish();
    }
}
