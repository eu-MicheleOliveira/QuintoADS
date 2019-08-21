package com.example.alunos.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PerguntaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        //obtemos acessso a intent que nos trouxe a essa tela
        Intent intent = getIntent();

        if(intent.getExtras() != null){
            // se entrarmos no if, ela trouxe!

            // Já que ela trouxe parametros, vamos pega-los.
          String pergunta = intent.getStringExtra("pergunta");
          String a  = intent.getStringExtra("a");
          String b = intent.getStringExtra("b");
          String c = intent.getStringExtra("c");
          String d = intent.getStringExtra("d");


             //Conectar os widgets da interface no código no Java
            TextView txtPergunta = (TextView) findViewById(R.id.txtPergunta);
            RadioButton rbA = (RadioButton)findViewById(R.id.rbA);
            RadioButton rbB = (RadioButton)findViewById(R.id.rbB);
            RadioButton rbC = (RadioButton)findViewById(R.id.rbC);
            RadioButton rbD = (RadioButton)findViewById(R.id.rbD);


            //mudamos o texto dos widgets para os paramentros obtidos
            txtPergunta.setText(pergunta);
            rbA.setText(a);
            rbB.setText(b);
            rbC.setText(c);
            rbD.setText(d);

        }
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
