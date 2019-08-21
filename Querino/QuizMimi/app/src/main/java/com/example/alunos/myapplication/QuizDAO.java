package com.example.alunos.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDAO extends SQLiteOpenHelper {

    public QuizDAO(Context context) {
        super(context, "perguntas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE perguntas(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "pergunta TEXT," +
                "altA TEXT," +
                "altB TEXT," +
                "altC TEXT," +
                "altD TEXT," +
                "altCorreta TEXT," +
                "respondido INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public ArrayList<Pergunta> GetPerguntas(){
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        SQLiteDatabase database = getWritableDatabase();
        int respondido;
        Cursor consulta = database.query("perguntas",null,null,null,null,null,"pergunta");

        while(consulta.moveToNext()){
            Pergunta pergunta = new Pergunta();
            pergunta.setPergunta(consulta.getString(1));
            pergunta.setAltA(consulta.getString(2));
            pergunta.setAltB(consulta.getString(3));
            pergunta.setAltC(consulta.getString(4));
            pergunta.setAltD(consulta.getString(5));
            pergunta.setAltCorreta(consulta.getString(6));
            respondido = consulta.getInt(7);
            if (respondido == 1) pergunta.setRespondido(true);
            else pergunta.setRespondido(false);

            perguntas.add(pergunta);
        }
        database.close();

        return perguntas;
    }

    public Pergunta getPergunta(int idPergunta){
        SQLiteDatabase database = getWritableDatabase();

        Cursor consulta = database.query("perguntas",null,null,null,null,null,"pergunta");

        int respondido;
        consulta.moveToPosition(idPergunta);
        Pergunta pergunta = new Pergunta();

        pergunta.setPergunta(consulta.getString(1));
        pergunta.setAltA(consulta.getString(2));
        pergunta.setAltB(consulta.getString(3));
        pergunta.setAltC(consulta.getString(4));
        pergunta.setAltD(consulta.getString(5));
        pergunta.setAltCorreta(consulta.getString(6));
        respondido = consulta.getInt(7);

        if (respondido == 1) pergunta.setRespondido(true);
        else pergunta.setRespondido(false);

        database.close();

        return pergunta;
    }

    public void CreatePergunta(Pergunta pergunta){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("pergunta",pergunta.getPergunta());
        values.put("altA",pergunta.getAltA());
        values.put("altB",pergunta.getAltB());
        values.put("altC",pergunta.getAltC());
        values.put("altD",pergunta.getAltD());
        values.put("altCorreta", pergunta.getAltCorreta());
        values.put("respondido", 0);
        database.insert("perguntas",null,values);

        database.close();
    }

    public void excluir(){
        SQLiteDatabase database = getWritableDatabase();

        database.execSQL("DELETE FROM perguntas");

        database.close();
    }
}
