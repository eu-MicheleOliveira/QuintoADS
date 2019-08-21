package com.example.alunos.conversores20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void converter(View view) {
        EditText edtLi = (EditText) findViewById(R.id.edtLi);
        EditText edtMl = (EditText) findViewById(R.id.edtMl);

        String strLitros = edtLi.getText().toString();
        String strMl = edtMl.getText().toString();


        if (!strLitros.isEmpty()) {
            //o usuario digitou algum valor no EditText Celsius !!!

            Litros Li = new Litros();

            double litros = Li.getLitrosfromMl(Double.parseDouble(strMl));
            edtLi.setText(String.valueOf(Li));
        } else if (!strMl.isEmpty()) {
            //o usuario digitou algum valor no EditText Fahrenheit!!

            Litros l = new Litros();

            double ml = l.getMlFromLitros(Double.parseDouble(strLitros));
            edtMl.setText(String.valueOf(ml));
        }

    }
}
