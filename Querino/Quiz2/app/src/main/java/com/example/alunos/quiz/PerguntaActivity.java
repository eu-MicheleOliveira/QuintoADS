package com.example.alunos.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PerguntaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
    }

    public void responder (View view){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int idRadioButtonClicado = radioGroup.getCheckedRadioButtonId();

            if (idRadioButtonClicado == R.id.rbB) {
                Toast.makeText(this, "Resposta certa! :) Congratulations!",
                        Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this,"Resposta errada... :( Sorry..",
                            Toast.LENGTH_LONG).show();

            }
    finish();
    }
}
