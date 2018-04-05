package com.example.aluno.atividade04_04;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class NovoContato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contato);
    }

    public void salvar(View view){
        SharedPreferences shared = getSharedPreferences("MainActivity", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        String jsonContato = shared.getString("contatos","sem contatos");
        Gson gson = new Gson();
        List<Contato> listaContatos = gson.fromJson(jsonContato,
                new TypeToken<List<Contato>>(){}.getType());

        EditText nome = (EditText) findViewById(R.id.editNome);
        EditText telefone = (EditText) findViewById(R.id.editTelefone);

        if (listaContatos == null)
            listaContatos = new ArrayList<>();

        Contato contato = new Contato(nome.getText().toString(), telefone.getText().toString(), R.drawable.contato);

        listaContatos.add(contato);

        String jsonContatos = gson.toJson(listaContatos);
        editor.putString("contatos", jsonContatos);
        editor.commit();
    }
}
