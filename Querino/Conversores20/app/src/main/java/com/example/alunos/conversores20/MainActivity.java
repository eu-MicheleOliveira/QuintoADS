package com.example.alunos.conversores20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void graus (View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void Litros (View view){
        Intent intent = new Intent (this, Main2Activity.class);
        startActivity(intent);
    }

}