package com.example.aluno.atividade04_04;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    private ListView listViewContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (popularLista() != null){
            AdapterContato adapter = new AdapterContato(this,popularLista());

            listViewContatos.setAdapter(adapter);
        }



    }

    private List<Contato> popularLista(){

        SharedPreferences lt = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = lt.edit();
        editor.putString("contatos","");
        editor.commit();

        //gson
        String contatoJson = lt.getString("contatos","nenhum");
        List<Contato> listacontatos = new ArrayList<>();
        if(!contatoJson.equals("nenhum")) {
            Gson gson = new Gson();
            listacontatos = gson.fromJson(contatoJson, new TypeToken<List<Contato>>() {
            }.getType());
        }


        return listacontatos;
    }

    public  void novoContato(View view){
        Intent intent = new
                Intent(this, NovoContato.class);
        startActivity(intent);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
