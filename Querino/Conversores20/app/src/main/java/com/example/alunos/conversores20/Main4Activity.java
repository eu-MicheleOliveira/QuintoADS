package com.example.alunos.conversores20;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void converter(View view) {
        EditText edtpol = (EditText) findViewById(R.id.edtpol);
        EditText edtcm = (EditText) findViewById(R.id.edtcm);

        String strPolegadas = edtpol.getText().toString();
        String strcm = edtcm.getText().toString();


        if (!strPolegadas.isEmpty()) {
            //o usuario digitou algum valor no EditText Celsius !!!

            Polegadas pol = new Polegadas();

            double cm = pol.getCmFromPolegada(Double.parseDouble(strPolegadas));
            edtcm.setText(String.valueOf(cm));
        } else if (!strcm.isEmpty()) {
            //o usuario digitou algum valor no EditText Fahrenheit!!

            Polegadas pol = new Polegadas();

            double polegada = pol.getPolegadaFromCm(Double.parseDouble(strcm));
            edtpol.setText(String.valueOf(polegada));
        }

    }
        public void Voltar (View view){
            finish();
    }
}
