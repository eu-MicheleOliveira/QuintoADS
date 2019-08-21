package com.antonio.fatecquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class PerguntasAdapter extends BaseAdapter {

    private final Context context;
    private final List<Pergunta> perguntas;

    public PerguntasAdapter(Context context, List<Pergunta> perguntas) {
        this.context = context;
        this.perguntas = perguntas;
    }

    @Override
    public int getCount() {
        return perguntas.size();
    }

    @Override
    public Pergunta getItem(int position) {
        return perguntas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return perguntas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pergunta pergunta = perguntas.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.item_list_quiz, parent, false);
        }
        ImageView imagem = view.findViewById(R.id.list_item_imagem);

        return view;
    }
}
