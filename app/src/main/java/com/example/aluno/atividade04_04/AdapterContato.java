package com.example.aluno.atividade04_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluno on 28/03/18.
 */

public class AdapterContato extends BaseAdapter{

    Context contexto;
    List<Contato> contatos;

    public AdapterContato(Context contexto,
                        List<Contato> contatos) {
        this.contexto = contexto;
        this.contatos = contatos;
    }

    @Override
    public int getCount() {

        return contatos.size();
    }

    @Override
    public Object getItem(int position){

        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {

        return contatos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha =
                LayoutInflater.from(contexto).
                        inflate(R.layout.linha_lista_contatos,parent,
                                false);
        ImageView imagemContato = (ImageView)
                viewLinha.findViewById(R.id.imagemContato);
        TextView nome = (TextView) viewLinha.findViewById(R.id.textViewNome);

        Contato contato = contatos.get(position);
        imagemContato.setImageResource(contato.getImagem());
        nome.setText(contato.getNome());

        return viewLinha;
    }
}
