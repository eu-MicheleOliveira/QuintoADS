package com.example.alunos.loteria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void quina(View view) {
        sortear(5,80);
    }

    public void megasena(View view) {
        sortear(6,60);
    }

    public void lotofacil(View view) {
        sortear(21, 25);
    }

    public void sortear(int quantidade, int total) {
        boolean existe = true;
        int vet[] = new int[quantidade];
        Random r = new Random();
        TextView txt = findViewById(R.id.textView);

        for (int i = 0; i < quantidade; i++) {
            vet[i] = r.nextInt(total) + 1;
            for (int j = 0; j < i; j++) {
                if (vet[i] == vet[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(vet);
        txt.setText(Arrays.toString(vet));
    }
}
