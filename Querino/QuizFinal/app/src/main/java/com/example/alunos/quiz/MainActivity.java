package com.example.alunos.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  int acertos = 0, erros = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirPergunta(View view){
        Intent abrirtela = new Intent(this, PerguntaActivity.class);
        startActivityForResult(abrirtela,0);
        view.setEnabled(false);
    }

    public void abrirPergunta2(View view){
        Intent intent = new Intent(this, PerguntaActivity.class);
        intent.putExtra("pergunta", "2 - Os arquivos de" +
                " layout que contem a especificação visual da tela são" +
        " criados no formato..");

        intent.putExtra("a", "PDE");
        intent.putExtra("b", "JPG");
        intent.putExtra("c", "DOCX");
        intent.putExtra("d", "XML");
        intent.putExtra("correta", R.id.rbD);
        startActivityForResult(intent,0);
        view.setEnabled(false);
    }

    public void abrirPergunta3(View view){
        Intent intent = new Intent(this, PerguntaActivity.class);
        intent.putExtra("pergunta", "3 - Qual o método usamos para acessar um widget na interface do código java?");

        intent.putExtra("a", "AccessWidget");
        intent.putExtra("b", "ConnectWidget");
        intent.putExtra("c", "findViewById");
        intent.putExtra("d", "AccessWidgetById");
        intent.putExtra("correta", R.id.rbC);
        startActivityForResult(intent,0);
        view.setEnabled(false);
    }

    public void abrirPergunta4(View view){
        Intent intent = new Intent(this, PerguntaActivity.class);
        intent.putExtra("pergunta", "4 - Todos os widgets são descendentes da classe...");

        intent.putExtra("a", "View");
        intent.putExtra("b", "Widget");
        intent.putExtra("c", "Activity");
        intent.putExtra("d", "Intent");
        intent.putExtra("correta", R.id.rbA);
        startActivityForResult(intent,0);
        view.setEnabled(false);
    }

    public void abrirPergunta5(View view){
        Intent intent = new Intent(this, PerguntaActivity.class);
        intent.putExtra("pergunta", "5 - Para passarmos parâmetro para outra activity por meio de intent usamos o método:");

        intent.putExtra("a", "PutParameter");
        intent.putExtra("b", "SendExtra");
        intent.putExtra("c", "SendParameter");
        intent.putExtra("d", "PutExtra");
        intent.putExtra("correta", R.id.rbD);
        startActivityForResult(intent,0);
        view.setEnabled(false);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        boolean acertou = data.getBooleanExtra("acertou",false);

        if(acertou){
            acertos++;
        } else {
            erros++;
        }
        TextView txtAcertos = (TextView) findViewById(R.id.txtAcertos);
        TextView txtErros = (TextView) findViewById(R.id.txtErros);

        double parcAcertos = acertos / (acertos + erros) * 100;
        double parcErros = erros / (acertos + erros) * 100;


        txtAcertos.setText("Acertos:" + acertos + "(" + Math.round(parcAcertos) + " %)" );
        txtErros.setText("Erros: " + erros + "(" +  Math.round(parcErros)  +  " %)");
    }
}