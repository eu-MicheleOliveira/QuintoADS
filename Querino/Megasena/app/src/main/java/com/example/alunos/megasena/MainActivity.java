package com.example.alunos.megasena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortear(View view){
        boolean existe=true;
        int vet[]=new int [6];
        Random r = new Random();
        TextView txt = (TextView) findViewById(R.id.txt);

        for (int i = 0; i < 6; i++) {
            vet[i]=r.nextInt(60)+1;
            for (int j = 0; j < i; j++) {
                if(vet[i]==vet[j]){
                    i--;
                    break;
                }
                }
                }


                Arrays.sort(vet);
               txt.setText(Arrays.toString(vet));


    }
}
