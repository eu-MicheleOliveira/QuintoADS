package com.example.alunos.listadetarefas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoOpenHelper extends SQLiteOpenHelper{


    public BancoOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tarefas (" + "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + "descricao TEXT, " + "data TEXT" + ")";

        db.execSQL(sql);
        sql = "INSERT INTO  tarefas (descricao, data) " +
                " VALUES ('Estudar Java', '20/05/2019')";

        db.execSQL(sql);
        sql = "INSERT INTO  tarefas (descricao, data) " +
                " VALUES ('Dar banho no catioro', '22/05/2019')";

        db.execSQL(sql);
        sql = "INSERT INTO  tarefas (descricao, data) " +
                " VALUES ('Fazer o trabalho do qrino', '24/05/2019')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
