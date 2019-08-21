package com.example.alunos.conversores20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void converter (View view){
        EditText edtCelsius = (EditText) findViewById (R.id.edtCelsius);
        EditText edtFahr = (EditText) findViewById(R.id.edtFahr);

        String strCelsius = edtCelsius.getText().toString();
        String strFahr = edtFahr.getText().toString();


        if (!strCelsius.isEmpty()) {
            //o usuario digitou algum valor no EditText Celsius !!!

            Temperatura temp = new Temperatura();

            double fahr = temp.getFahrFromCelsius(Double.parseDouble(strCelsius));
            edtFahr.setText(String.valueOf(fahr));
        } else if (!strFahr.isEmpty()) {
            //o usuario digitou algum valor no EditText Fahrenheit!!

            Temperatura temp = new Temperatura();

            double celsius = temp.getCelsiusFromFahr (Double.parseDouble(strFahr));
            edtCelsius.setText(String.valueOf(celsius));
        }
    }
}
